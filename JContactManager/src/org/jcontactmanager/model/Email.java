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
public class Email extends Communicator{
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
