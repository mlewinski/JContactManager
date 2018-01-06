package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static org.jcontactmanager.util.SqlTools.sanitizeQuery;

/**
 * Created by mlewinski on 11/10/17.
 */
public class PhoneNumber extends Communicator{
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty number = new SimpleStringProperty();
    private StringProperty network = new SimpleStringProperty();

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

    public StringProperty numberProperty() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public String getNetwork() {
        return network.get();
    }

    public StringProperty getNetworkProperty() {
        return network;
    }

    public void setNetwork(String network) {
        this.network.set(network);
    }

    @Override
    public String saveQuery() {
        return sanitizeQuery("INSERT INTO PhoneNumbers VALUES(" + this.id + "," + this.number + "," + this.network + ")");
    }

    @Override
    public String updateQuery() {
        return sanitizeQuery("UPDATE PhoneNumbers SET Number="+this.number+ "," + "Network=" + this.network);
    }

    @Override
    public String deleteQuery() {
        return sanitizeQuery("DELETE FROM PhoneNubmers WHERE Number=" + this.number + " AND Network=" + this.network);
    }

    @Override
    public String selectQuery() {
        return null;
    }
}
