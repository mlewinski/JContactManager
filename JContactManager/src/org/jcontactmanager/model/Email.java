package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static org.jcontactmanager.util.SqlTools.sanitizeQuery;


/**
 * Created by mlewinski on 11/10/17.
 */

/*
    TODO : zmienić nazwy tabel i kolumn
 */
public class Email implements IStoreable{
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty privateEmailAddress = new SimpleStringProperty();
    private StringProperty workEmailAddress = new SimpleStringProperty();

    public Email() {
    }

    public Email(int id, String privateEmailAddress, String workEmailAddress) {
        this.id = new SimpleIntegerProperty(id);
        this.privateEmailAddress = new SimpleStringProperty(privateEmailAddress);
        this.workEmailAddress = new SimpleStringProperty(workEmailAddress);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getPrivateEmailAddress() {
        return privateEmailAddress.get();
    }

    public StringProperty privateEmailAddressProperty() {
        return privateEmailAddress;
    }

    public void setPrivateEmailAddress(String privateEmailAddress) {
        this.privateEmailAddress.set(privateEmailAddress);
    }

    public String getWorkEmailAddress() {
        return workEmailAddress.get();
    }

    public StringProperty workEmailAddressProperty() {
        return workEmailAddress;
    }

    public void setWorkEmailAddress(String workEmailAddress) {
        this.workEmailAddress.set(workEmailAddress);
    }

    @Override
    public String saveQuery(){
        return "INSERT INTO Emails VALUES('" + this.id.getValue() + "','" + this.privateEmailAddress.getValue() + "','" + this.workEmailAddress.getValue() + "')";
    }

    @Override
    public String updateQuery() {
        return sanitizeQuery("UPDATE Emails SET ID="+this.id+", PrivateEmailAddress=" + this.privateEmailAddress + ", WorkEmailAddress=" + this.workEmailAddress);
    }

    @Override
    public String deleteQuery() {
        return "DELETE FROM Emails WHERE ID =" + this.id.getValue();
    }

    @Override
    public String selectQuery(){return null;}
}
