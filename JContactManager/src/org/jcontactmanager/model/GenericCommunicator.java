package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by mlewinski on 11/10/17.
 */
public class GenericCommunicator extends Communicator{
    private IntegerProperty id;
    private StringProperty address;
    private StringProperty protocol;

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

    public StringProperty getAddressProperty() {
        return address;
    }

    public void setAddress(StringProperty address) {
        this.address = address;
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty getProtocolProperty() {
        return protocol;
    }

    public void setProtocol(StringProperty protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol.get();
    }

}
