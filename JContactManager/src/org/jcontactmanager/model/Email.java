package org.jcontactmanager.model;

/**
 * Created by mlewinski on 11/10/17.
 */
public class Email extends Communicator{
    public String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
