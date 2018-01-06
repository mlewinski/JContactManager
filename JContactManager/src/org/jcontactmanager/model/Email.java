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
    private StringProperty emailAddress = new SimpleStringProperty();

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

    public String getEmailAddress() {
        return emailAddress.get();
    }

    public StringProperty emailAddressProperty() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress.set(emailAddress);
    }

    @Override
    public String saveQuery(){
        return sanitizeQuery("INSERT INTO Emails VALUES(" + this.id + "," + this.emailAddress+")");
    }

    @Override
    public String updateQuery() {
        return sanitizeQuery("UPDATE Emails SET ID="+this.id+", EmailAddress="+this.emailAddress);
    }

    @Override
    public String deleteQuery() {
        return sanitizeQuery("DELETE FROM Emails WHERE ID =" + this.id + " AND EmailAddress=" + this.emailAddress);
    }

    @Override
    public String selectQuery(){return null;}
}
