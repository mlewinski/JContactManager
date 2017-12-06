package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by mlewinski on 11/10/17.
 */
public class Contact {
    private IntegerProperty id;
    private IntegerProperty ownerID;
    private ObjectProperty<List<Email>> emailAddresses;
    private ObjectProperty<List<PhoneNumber>> phoneNumbers;
    private ObjectProperty<List<GenericCommunicator>> otherCommunicators;
    private ObjectProperty<ContactInformation> contactInformation;
    private ObjectProperty<Date> created;

    public int getId() {
        return id.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getOwnerID() {
        return ownerID.get();
    }

    public IntegerProperty getOwnerIDProperty() {
        return id;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID.set(ownerID);
    }

    public List<Email> getEmailAddresses() {
        return emailAddresses.get();
    }

    public ObjectProperty<List<Email>> getEmailAddressesProperty() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<Email> emailAddresses) {
        this.emailAddresses.set(emailAddresses);
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers.get();
    }

    public ObjectProperty<List<PhoneNumber>> getPhoneNumbersProperty() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers.set(phoneNumbers);
    }

    public List<GenericCommunicator> getOtherCommunicators() {
        return otherCommunicators.get();
    }

    public ObjectProperty<List<GenericCommunicator>> getOtherCommunicatorsProperty() {
        return otherCommunicators;
    }

    public void setOtherCommunicators(List<GenericCommunicator> otherCommunicators) {
        this.otherCommunicators.set(otherCommunicators);
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

    public Date getCreated() {
        return created.get();
    }

    public ObjectProperty<Date> getCreatedProperty() {
        return created;
    }

    public void setCreated(Date created) {
        this.created.set(created);
    }
}
