package org.jcontactmanager.model;

import javafx.beans.property.StringProperty;

/**
 * Created by mlewinski on 11/10/17.
 */
public class Email extends Communicator{
    public StringProperty emailAddress;

    public StringProperty getEmailAddressProperty() {
        return emailAddress;
    }

    public void setEmailAddress(StringProperty emailAddress) {
        this.emailAddress = emailAddress;
    }
}
