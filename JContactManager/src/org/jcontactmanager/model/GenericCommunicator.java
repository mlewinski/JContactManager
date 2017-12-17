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

    public void setAddress(String address) {
        this.address.setValue(address);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty getProtocolProperty() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol.setValue(protocol);
    }

    public String getProtocol() {
        return protocol.get();
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
