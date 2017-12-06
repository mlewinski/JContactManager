package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by mlewinski on 11/10/17.
 */
public class PhoneNumber extends Communicator{
    private IntegerProperty id;
    private StringProperty number;
    private StringProperty Network;

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

    public String getNumber() {
        return number.get();
    }

    public StringProperty getNumberProperty() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public String getNetwork() {
        return Network.get();
    }

    public StringProperty getNetworkProperty() {
        return Network;
    }

    public void setNetwork(String network) {
        Network.set(network);
    }
}
