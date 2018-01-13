package org.jcontactmanager.model;

import javafx.beans.property.*;

import static org.jcontactmanager.util.SqlTools.sanitizeQuery;

/**
 * Created by mlewinski on 11/10/17.
 */
public class Messengers implements IStoreable {
    protected IntegerProperty id = new SimpleIntegerProperty();
    protected IntegerProperty ownerID = new SimpleIntegerProperty();
    protected StringProperty note = new SimpleStringProperty();
    protected ObjectProperty<Email> emails = new SimpleObjectProperty<>();
    protected ObjectProperty<PhoneNumber> phoneNumbers = new SimpleObjectProperty<>();

    public Messengers(int id, String note, Email emails, PhoneNumber phoneNumbers) {
        this.id = new SimpleIntegerProperty(id);
        this.note = new SimpleStringProperty(note);
        this.emails = new SimpleObjectProperty(emails);
        this.phoneNumbers = new SimpleObjectProperty(phoneNumbers);
    }

    public Messengers() {
    }

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


    public String saveQuery() {
        return sanitizeQuery("INSERT INTO Messengers VALUES(" + this.id + "," + this.note + ")");
    }

    @Override
    public String updateQuery() {
        return sanitizeQuery("UPDATE PhoneNumbers SET ID="+this.id+ ", PrivateNumber=" + this.note);
    }

    @Override
    public String deleteQuery() {
        return sanitizeQuery("DELETE FROM PhoneNubmers WHERE ID=" + this.id);
    }

    @Override
    public String selectQuery() {
        return null;
    }
}
