package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by mlewinski on 11/10/17.
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

    public void setEmailAddress(StringProperty emailAddress) {
        this.emailAddress = emailAddress;
    }
}
