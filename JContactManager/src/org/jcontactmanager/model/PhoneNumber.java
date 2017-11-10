package org.jcontactmanager.model;

/**
 * Created by mlewinski on 11/10/17.
 */
public class PhoneNumber extends Communicator{
    public String number;
    public String Network;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNetwork() {
        return Network;
    }

    public void setNetwork(String network) {
        Network = network;
    }
}
