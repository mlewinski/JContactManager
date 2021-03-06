package org.jcontactmanager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.jcontactmanager.util.JcmLogger;
import org.jcontactmanager.util.SqlTools;

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
     *
     * @return List of contacts reference
     */
    public ObservableList<Contact> getRepositoryReference() {
        return _repository;
    }


    /**
     * Perform operation on the object in a database
     *
     * @param sql SQL representation of an object
     * @throws SQLException
     * @throws IOException
     * @see IStoreable
     */
    public void execute(String sql) throws SQLException, IOException {
        try (Connection conn = getConnection(); Statement stm = conn.createStatement()) {
            stm.executeUpdate(sql);
        } catch (SQLException | IOException ex) {
            try{
                JcmLogger.LogError(ex.getMessage());
            } catch(IOException e){}
            throw ex;
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
                JcmLogger.LogError(e.getMessage());
            } catch (IOException ex) {}
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem with the database");
            alert.setHeaderText("The application has encountered error with the database. It is not possible for the application to continue. Please refer to the information below.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (IOException e) {
            try{
                JcmLogger.LogError(e.getMessage());
            } catch(IOException ex){}
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("The database config file cannot be accessed");
            alert.setHeaderText("The application cannot find the database.properties file or it is inaccessible. Please generate a new config file using Settings.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    /**
     * Retrieves all contacts from the database and builds the object tree
     *
     * @throws SQLException
     * @throws IOException
     */
    private void fetchAllContacts() throws SQLException, IOException {
        try (Connection conn = getConnection(); Statement stm = conn.createStatement()) {
            try (ResultSet contacts = stm.executeQuery("SELECT * FROM `Contacts` ")) {
                if (contacts == null) {
                    try{
                        JcmLogger.LogMessage("0 contacts found in the database");
                    } catch(IOException ex){}
                    return;
                }
                while (contacts.next()) {
                    Contact newContact = new Contact();
                    int contactID = contacts.getInt("ID");
                    newContact.setId(contactID);
                    try (ResultSet messengers = conn.createStatement().executeQuery("SELECT * FROM `Messengers` INNER JOIN `Emails` ON Messengers.ID=Emails.ID  INNER JOIN `PhoneNumbers` ON Messengers.ID=PhoneNumbers.ID WHERE Messengers.ID=" + contactID)) {
                        while (messengers.next()) {
                            Messengers msg = new Messengers();
                            Email email = new Email();
                            email.setId(contactID);
                            email.setPrivateEmailAddress(messengers.getString("PrivateEmailAddress"));
                            email.setWorkEmailAddress(messengers.getString("WorkEmailAddress"));
                            msg.setEmails(email);
                            PhoneNumber phoneNumber = new PhoneNumber();
                            phoneNumber.setId(contactID);
                            phoneNumber.setPrivateNumber(messengers.getString("PrivateNumber"));
                            phoneNumber.setPrivateNetwork(messengers.getString("PrivateNetwork"));
                            phoneNumber.setWorkNumber(messengers.getString("WorkNumber"));
                            phoneNumber.setWorkNetwork(messengers.getString("WorkNetwork"));
                            msg.setPhoneNumbers(phoneNumber);
                            msg.setId(contactID);
                            msg.setNote(messengers.getString("Note"));
                            newContact.setMessengers(msg);
                        }
                    }
                    ContactInformation contactInformation = new ContactInformation();
                    try (ResultSet contactInfo = conn.createStatement().executeQuery("SELECT * FROM `ContactsInformations` WHERE ID=" + contactID)) {
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
     *
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
