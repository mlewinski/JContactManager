package org.jcontactmanager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.jcontactmanager.util.JcmLogger;

import java.nio.file.*;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class ContactRepository {

    private ObservableList<Contact> _repository;
    private final JcmLogger logger;

    public ContactRepository() {
        _repository = FXCollections.observableArrayList();
        logger = new JcmLogger("logs/log-" + (new SimpleDateFormat("dd-MM-yyyy").format(new Date())) + ".txt");
        loadContacts();
    }

    /**
     * Returns a reference to the list  that contains fetched contacts
     * @return List of contacts reference
     */
    public ObservableList<Contact> getRepositoryReference() {
        return _repository;
    }

    public void update(String sql) {

    }

    public void delete(String sql) {

    }

    /**
     * Save object to a database
     * @param sql SQL representation of an object
     *            @see IStoreable
     * @throws SQLException
     * @throws IOException
     */
    public void save(String sql) throws SQLException, IOException {
        try (Connection conn = getConnection(); Statement stm = conn.createStatement()) {
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem with the database");
            alert.setHeaderText("The application has encountered error with the database. It is not possible for the application to continue. Please refer to the information below.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("The database config file cannot be accessed");
            alert.setHeaderText("The application cannot find the database.properties file or it is inaccessible. Please generate a new config file using Settings.");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    /**
     * Load contacts from the database with the exceptions control.
     */
    private void loadContacts() {
        try {
            fetchAllContacts();
        } catch (SQLException e) {
            try {
                logger.LogError(e.getMessage());
            } catch (IOException superException) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Super Exception Occurred");
                alert.setHeaderText("The application has encountered super error while trying to access the log file. Application cannot continue. Check permissions of logs directory.");
                alert.setContentText(superException.getMessage());
                alert.showAndWait();
                System.exit(-1);
            }
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem with the database");
            alert.setHeaderText("The application has encountered error with the database. It is not possible for the application to continue. Please refer to the information below.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("The database config file cannot be accessed");
            alert.setHeaderText("The application cannot find the database.properties file or it is inaccessible. Please generate a new config file using Settings.");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    /**
     * Retrieves all contacts from the database and builds the object tree
     * @throws SQLException
     * @throws IOException
     */
    private void fetchAllContacts() throws SQLException, IOException {
        try (Connection conn = getConnection(); Statement stm = conn.createStatement()) {
            try (ResultSet contacts = stm.executeQuery("SELECT * FROM `Contacts` ")) {
                if (contacts == null) return;
                while (contacts.next()) {
                    Contact newContact = new Contact();
                    int contactID = contacts.getInt("ID");
                    newContact.setId(contactID);
                    try (ResultSet emails = conn.createStatement().executeQuery("SELECT * FROM `Communicators` INNER JOIN `Emails` ON Communicators.ID=Emails.ID WHERE Communicators.OwnerID=" + contactID)) {
                        while (emails.next()) {
                            Email email = new Email();
                            email.setId(emails.getInt("ID"));
                            email.setNote(emails.getString("Note"));
                            email.setLabel(emails.getString("Label"));
                            email.setPrivateEmailAddress(emails.getString("PrivateEmailAddress"));
                            newContact.setEmailAddress(email);
                        }
                    }
                    try (ResultSet emails = conn.createStatement().executeQuery("SELECT * FROM `Communicators` INNER JOIN `Emails` ON Communicators.ID=Emails.ID WHERE Communicators.OwnerID=" + contactID)) {
                        while (emails.next()) {
                            Email email = new Email();
                            email.setId(emails.getInt("ID"));
                            email.setNote(emails.getString("Note"));
                            email.setLabel(emails.getString("Label"));
                            email.setWorkEmailAddress(emails.getString("EmailAddress"));
                            newContact.setEmailAddress(email);
                        }
                    }
                    try (ResultSet phoneNumbers = conn.createStatement().executeQuery("SELECT * FROM `Communicators` INNER JOIN `PhoneNumbers` ON Communicators.ID=PhoneNumbers.ID WHERE Communicators.OwnerID=" + contactID)) {
                        while (phoneNumbers.next()) {
                            PhoneNumber phoneNumber = new PhoneNumber();
                            phoneNumber.setId(phoneNumbers.getInt("ID"));
                            phoneNumber.setNote(phoneNumbers.getString("Note"));
                            phoneNumber.setLabel(phoneNumbers.getString("Label"));
                            phoneNumber.setPrivateNumber(phoneNumbers.getString("Number"));
                            phoneNumber.setPrivateNetwork((phoneNumbers.getString("Network")));
                            newContact.setPhoneNumber(phoneNumber);
                        }
                    }
                    try (ResultSet phoneNumbers = conn.createStatement().executeQuery("SELECT * FROM `Communicators` INNER JOIN `PhoneNumbers` ON Communicators.ID=PhoneNumbers.ID WHERE Communicators.OwnerID=" + contactID)) {
                        while (phoneNumbers.next()) {
                            PhoneNumber phoneNumber = new PhoneNumber();
                            phoneNumber.setId(phoneNumbers.getInt("ID"));
                            phoneNumber.setNote(phoneNumbers.getString("Note"));
                            phoneNumber.setLabel(phoneNumbers.getString("Label"));
                            phoneNumber.setWorkNumber(phoneNumbers.getString("Number"));
                            phoneNumber.setWorkNetwork(phoneNumbers.getString("Network"));
                            newContact.setPhoneNumber(phoneNumber);
                        }
                    }
                    ContactInformation contactInformation = new ContactInformation();
                    try (ResultSet contactInfo = conn.createStatement().executeQuery("SELECT * FROM `ContactInformations` WHERE ID=" + contactID)) {
                        while (contactInfo.next()) {
                            contactInformation.setId(contactInfo.getInt("ID"));
                            contactInformation.setName(contactInfo.getString("Name"));
                            contactInformation.setAddress(contactInfo.getString("Address"));
                            contactInformation.setCity(contactInfo.getString("City"));
                            contactInformation.setCountry(contactInfo.getString("Country"));
                            contactInformation.setNote(contactInfo.getString("Note"));
                            contactInformation.setWebsite(contactInfo.getString("Website"));
                            contactInformation.setNickname(contactInfo.getString("Nickname"));
                            contactInformation.setGender(contactInfo.getString("Gender"));
                        }
                    }
                    newContact.setContactInformation(contactInformation);
                    _repository.add(newContact);
                }
            }
        }
    }

    /**
     * Returns a configured connection object
     * @return JDBC connection object
     * @throws SQLException
     * @throws IOException
     */
    private static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(Paths.get(".", "/", "JContactManager/database.properties").normalize())) {
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) System.setProperty("jdbc.drivers", drivers);
        String url = props.getProperty("jdbc.url");
        String uname = props.getProperty("jdbc.username");
        String pass = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, uname, pass);
    }

}
