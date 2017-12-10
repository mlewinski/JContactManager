package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import org.jcontactmanager.util.SqlTools;


/**
 * Created by mlewinski on 11/10/17.
 */

/*
    TODO : zmienić nazwy tabel i kolumn
 */
public class Email extends Communicator implements IStoreable{
    private IntegerProperty id;
    private StringProperty emailAddress;

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

    public String getEmailAddress() { return emailAddress.get(); }

    public StringProperty getEmailAddressProperty() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress.set(SqlTools.sanitizeQuery(emailAddress));
    }

    public String saveQuery(){
        return "INSERT INTO Emails(ID, EmailAddress) VALUES (" + this.id.getValue() + ", '" + emailAddress.getValue() + "')";
    }

    public String updateQuery(){
        return "UPDATE Emails SET EmailAddress=" + emailAddress.getValue() + " WHERE ID=" + id.getValue();
    }

    public String deleteQuery(){
        return "DELETE * FROM Emails WHERE ID=" + id.getValue();
    }

    public String selectQuery(){
        return "DELETE * FROM Emails WHERE ID=" + id.getValue();
    }
}
