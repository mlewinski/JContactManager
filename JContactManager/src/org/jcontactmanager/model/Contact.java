package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by mlewinski on 11/10/17.
 */
public class Contact implements IStoreable {
    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<Email> privateEmailAddress = new SimpleObjectProperty<>();
    private ObjectProperty<Email> workEmailAddress = new SimpleObjectProperty<>();
    private ObjectProperty<PhoneNumber> privatePhoneNumber = new SimpleObjectProperty<>();
    private ObjectProperty<PhoneNumber> workPhoneNumber = new SimpleObjectProperty<>();
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

    public Email getPrivateEmailAddress() {
        return privateEmailAddress.get();
    }

    public ObjectProperty<Email> getPrivateEmailAddressesProperty() {
        return privateEmailAddress;
    }

    public void setPrivateEmailAddresses(Email emailAddress) {
        this.privateEmailAddress.set(emailAddress);
    }
    public Email getWorkEmailAddress() {
        return workEmailAddress.get();
    }

    public ObjectProperty<Email> getWorkEmailAddressesProperty() {
        return workEmailAddress;
    }

    public void setWorkEmailAddress(Email emailAddress) {
        this.workEmailAddress.set(emailAddress);
    }

    public PhoneNumber getPrivatePhoneNumber() {
        return privatePhoneNumber.get();
    }

    public ObjectProperty<PhoneNumber> getPrivatePhoneNumberProperty() {
        return privatePhoneNumber;
    }

    public void setPrivatePhoneNumber(PhoneNumber phoneNumber) {
        this.privatePhoneNumber.set(phoneNumber);
    }

    public PhoneNumber getWorkPhoneNumber() {
        return workPhoneNumber.get();
    }

    public ObjectProperty<PhoneNumber> getWorkPhoneNumberProperty() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(PhoneNumber phoneNumber) {
        this.workPhoneNumber.set(phoneNumber);
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
    public String saveQuery() {
        return null;
    }

    @Override
    public String updateQuery() {
        return null;
    }

    @Override
    public String deleteQuery() {
        return null;
    }

    @Override
    public String selectQuery() {
        return null;
    }
}
