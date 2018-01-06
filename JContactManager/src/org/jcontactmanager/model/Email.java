package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static org.jcontactmanager.util.SqlTools.sanitizeQuery;


/**
 * Created by mlewinski on 11/10/17.
 */

/*
    TODO : zmienić nazwy tabel i kolumn
 */
public class Email extends Communicator{
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty privateEmailAddress = new SimpleStringProperty();
    private StringProperty workEmailAddress = new SimpleStringProperty();

    public Email() {
        this.id = null;
        this.privateEmailAddress = null;
        this.workEmailAddress = null;
        this.note = null;
    }

    public Email(int id, String privateEmailAddress, String workEmailAddress, String note) {
        this.id = new SimpleIntegerProperty(id);
        this.privateEmailAddress = new SimpleStringProperty(privateEmailAddress);
        this.workEmailAddress = new SimpleStringProperty(workEmailAddress);
        this.note = new SimpleStringProperty(note);
    }

    @Override
    public int getId() {
        return id.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Override
    public String getNote() {
        return super.getNote();
    }

    @Override
    public StringProperty getNoteProperty() {
        return super.getNoteProperty();
    }

    @Override
    public void setNote(String note) {
        super.setNote(note);
    }


    public String getPrivateEmailAddress() {
        return privateEmailAddress.get();
    }

    public StringProperty privateEmailAddressProperty() {
        return privateEmailAddress;
    }

    public void setPrivateEmailAddress(String privateEmailAddress) {
        this.privateEmailAddress.set(privateEmailAddress);
    }

    public String getWorkEmailAddress() {
        return workEmailAddress.get();
    }

    public StringProperty workEmailAddressProperty() {
        return workEmailAddress;
    }

    public void setWorkEmailAddress(String workEmailAddress) {
        this.workEmailAddress.set(workEmailAddress);
    }

    @Override
    public String saveQuery(){
        return sanitizeQuery("INSERT INTO Emails VALUES(" + this.id + "," + this.privateEmailAddress + "," + this.workEmailAddress + ")");
    }

    @Override
    public String updateQuery() {
        return sanitizeQuery("UPDATE Emails SET ID="+this.id+", PrivateEmailAddress=" + this.privateEmailAddress + ", WorkEmailAddress=" + this.workEmailAddress);
    }

    @Override
    public String deleteQuery() {
        return sanitizeQuery("DELETE FROM Emails WHERE ID =" + this.id + " AND PrivateEmailAddress=" + this.privateEmailAddress+ " AND WorkEmailAddress="+ this.workEmailAddress);
    }

    @Override
    public String selectQuery(){return null;}
}
