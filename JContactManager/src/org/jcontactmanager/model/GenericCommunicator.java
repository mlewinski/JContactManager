package org.jcontactmanager.model;

import javafx.beans.property.StringProperty;

/**
 * Created by mlewinski on 11/10/17.
 */
public class GenericCommunicator extends Communicator{
    public StringProperty address;
    public StringProperty protocol;

    public StringProperty getAddressProperty() {
        return address;
    }

    public void setAddress(StringProperty address) {
        this.address = address;
    }

    public StringProperty getProtocolProperty() {
        return protocol;
    }

    public void setProtocol(StringProperty protocol) {
        this.protocol = protocol;
    }
}
