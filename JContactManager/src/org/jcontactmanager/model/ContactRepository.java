package org.jcontactmanager.model;

import java.nio.file.*;
import java.sql.*;
import java.io.*;
import java.util.*;


public class ContactRepository {

    private List<Contact> _repository;

    public ContactRepository(){
        _repository = new ArrayList<>(128);
    }

    public void update(String sql){

    }

    public void delete(String sql){

    }

    public void save(){

    }

    private void fetchAllContacts() throws SQLException, IOException{
        try(Connection conn = getConnection(); Statement stm = conn.createStatement()){
            try(ResultSet contacts = stm.executeQuery("SELECT * FROM Contacts")){
                while(contacts.next()){
                    Contact newContact = new Contact();
                    int contactID = contacts.getInt("ID");
                    newContact.setId(contactID);
                    List<Email> emailList = new ArrayList<Email>();
                    try(ResultSet emails = stm.executeQuery("SELECT * FROM `Communicators` INNER JOIN `Emails` ON Communicators.ID=Emails.ID WHERE Communicators.OwnerID="+contactID)){
                        while(emails.next()){
                            Email email = new Email();
                            email.setId(emails.getInt("ID"));
                            email.setCategory(emails.getString("Category"));
                            email.setNote(emails.getString("Note"));
                            email.setLabel(emails.getString("Label"));
                            email.setEmailAddress(emails.getString("EmailAddress"));
                            emailList.add(email);
                        }
                    }
                    List<PhoneNumber> phoneNumberList = new ArrayList<PhoneNumber>();
                    try(ResultSet phoneNumbers = stm.executeQuery("SELECT * FROM `Communicators` INNER JOIN `PhoneNumbers` ON Communicators.ID=PhoneNumbers.ID WHERE Communicators.OwnerID="+contactID)){
                        while(phoneNumbers.next()){
                            PhoneNumber phoneNumber = new PhoneNumber();
                            phoneNumber.setId(phoneNumbers.getInt("ID"));
                            phoneNumber.setCategory(phoneNumbers.getString("Category"));
                            phoneNumber.setNote(phoneNumbers.getString("Note"));
                            phoneNumber.setLabel(phoneNumbers.getString("Label"));
                            phoneNumber.setNumber(phoneNumbers.getString("EmailAddress"));
                            phoneNumber.setNetwork((phoneNumbers.getString("Network")));
                            phoneNumberList.add(phoneNumber);
                        }
                    }
                    List<GenericCommunicator> genericCommunicatorList = new ArrayList<GenericCommunicator>();
                    try(ResultSet genericCommunicators = stm.executeQuery("SELECT * FROM `Communicators` INNER JOIND `GenericComms` ON Communicators.ID=GenericComms.ID WHERE Communicators.OwnerID="+contactID)){
                        while(genericCommunicators.next()){
                            GenericCommunicator genericCommunicator = new GenericCommunicator();
                            genericCommunicator.setId(genericCommunicators.getInt("ID"));
                            genericCommunicator.setCategory(genericCommunicators.getString("Category"));
                            genericCommunicator.setNote(genericCommunicators.getString("Note"));
                            genericCommunicator.setLabel(genericCommunicators.getString("Label"));
                            genericCommunicator.setProtocol(genericCommunicators.getString("Protocol"));
                            genericCommunicator.setAddress(genericCommunicators.getString("Address"));
                            genericCommunicatorList.add(genericCommunicator);
                        }
                    }
                    ContactInformation contactInformation = new ContactInformation();
                    try(ResultSet contactInfo = stm.executeQuery("SELECT * FROM `ContactInformations` WHERE OwnerID="+contactID)){
                        while(contactInfo.next()){
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
                    newContact.setEmailAddresses(emailList);
                    newContact.setPhoneNumbers(phoneNumberList);
                    newContact.setOtherCommunicators(genericCommunicatorList);
                    _repository.add(newContact);
                }
            }
        }
    }

    private static Connection getConnection() throws SQLException, IOException{
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get(".","resources", "database.properties").normalize())){
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.drivers");
        if(drivers!=null) System.setProperty("jdbc.drivers", drivers);
        String url = props.getProperty("jdbc.url");
        String uname = props.getProperty("jdbc.username");
        String pass = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, uname, pass);
    }
}
