package org.jcontactmanager.model;

import java.util.Date;
import java.util.List;

/**
 * Created by mlewinski on 11/10/17.
 */
public class Contact {
    public int ID;
    public int ownerID;
    public List<Email> emailAddresses;
    public List<PhoneNumber> phoneNumbers;
    public List<GenericCommunicator> otherCommunicators;
    public ContactInformation contactInformation;
    public Date created;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public List<Email> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<Email> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<GenericCommunicator> getOtherCommunicators() {
        return otherCommunicators;
    }

    public void setOtherCommunicators(List<GenericCommunicator> otherCommunicators) {
        this.otherCommunicators = otherCommunicators;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
