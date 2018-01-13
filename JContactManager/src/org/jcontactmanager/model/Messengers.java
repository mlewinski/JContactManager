package org.jcontactmanager.model;

import javafx.beans.property.*;

/**
 * Created by mlewinski on 11/10/17.
 */
public class Messengers implements IStoreable {
    protected IntegerProperty id = new SimpleIntegerProperty();
    protected IntegerProperty ownerID = new SimpleIntegerProperty();
    protected StringProperty note = new SimpleStringProperty();
    protected ObjectProperty<Email> emails = new SimpleObjectProperty<>();
    protected ObjectProperty<PhoneNumber> phoneNumbers = new SimpleObjectProperty<>();

    public int getId() {
        return id.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getOwnerId() {
        return ownerID.get();
    }

    public IntegerProperty getOwnerIdProperty() {
        return ownerID;
    }

    public void setOwnerID(int id) {
        this.ownerID.set(id);
    }

    public String getNote() {
        return note.get();
    }

    public StringProperty getNoteProperty() {
        return note;
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    public Email getEmails() {
        return emails.get();
    }

    public ObjectProperty getEmailsProperty() {
        return emails;
    }

    public void setEmails(Email emails) {
        this.emails.setValue(emails);
    }

    public PhoneNumber getPhoneNumbers() {
        return phoneNumbers.get();
    }

    public ObjectProperty getPhoneNumbersProperty() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(PhoneNumber phoneNumbers) {
        this.phoneNumbers.setValue(phoneNumbers);
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
