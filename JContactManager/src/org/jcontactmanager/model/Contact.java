package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;
import java.util.List;

import static org.jcontactmanager.util.SqlTools.sanitizeQuery;

/**
 * Created by mlewinski on 11/10/17.
 */
public class Contact implements IStoreable {
    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<Email> emailAddress = new SimpleObjectProperty<>();
    private ObjectProperty<PhoneNumber> phoneNumber = new SimpleObjectProperty<>();
    private ObjectProperty<ContactInformation> contactInformation = new SimpleObjectProperty<>();

    public int getId() {
        return id.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public Email getEmailAddress() {
        return emailAddress.get();
    }

    public ObjectProperty<Email> emailAddressProperty() {
        return emailAddress;
    }

    public void setEmailAddress(Email emailAddress) {
        this.emailAddress.set(emailAddress);
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber.get();
    }

    public ObjectProperty<PhoneNumber> phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public ContactInformation getContactInformation() {
        return contactInformation.get();
    }

    public ObjectProperty<ContactInformation> getContactInformationProperty() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation.set(contactInformation);
    }

    @Override
    public String saveQuery(){
        return sanitizeQuery("INSERT INTO Emails VALUES(" + this.id + "," + getContactInformation().getId() + "," + getPhoneNumber().getId() + ")");
    }

    @Override
    public String updateQuery() {
        return sanitizeQuery("UPDATE Emails SET ID="+this.id+", ContactInformationId=" + getContactInformation().getId() + ", CommunicatorId=" + getPhoneNumber().getId());
    }

    @Override
    public String deleteQuery() {
        return sanitizeQuery("DELETE FROM Emails WHERE ID =" + this.id);
    }

    @Override
    public String selectQuery() {
        return null;
    }
}
