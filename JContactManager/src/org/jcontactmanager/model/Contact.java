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
    private ObjectProperty<List<Email>> emailAddresses = new SimpleObjectProperty<>();
    private ObjectProperty<List<PhoneNumber>> phoneNumbers = new SimpleObjectProperty<>();
    private ObjectProperty<List<GenericCommunicator>> otherCommunicators = new SimpleObjectProperty<>();
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
