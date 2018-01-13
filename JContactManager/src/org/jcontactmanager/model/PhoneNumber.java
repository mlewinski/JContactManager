package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static org.jcontactmanager.util.SqlTools.sanitizeQuery;

/**
 * Created by mlewinski on 11/10/17.
 */
public class PhoneNumber implements IStoreable{
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty workNumber = new SimpleStringProperty();
    private StringProperty privateNumber = new SimpleStringProperty();
    private StringProperty workNetwork = new SimpleStringProperty();
    private StringProperty privateNetwork = new SimpleStringProperty();

    public PhoneNumber() {
        this.id = null;
        this.workNumber = null;
        this.workNetwork = null;
        this.privateNumber = null;
        this.privateNetwork = null;
    }

    public PhoneNumber(int id, String workNumber, String privateNumber, String workNetwork, String privateNetwork) {
        this.id = new SimpleIntegerProperty(id);
        this.workNumber = new SimpleStringProperty(workNumber);
        this.privateNumber = new SimpleStringProperty(privateNumber);
        this.workNetwork = new SimpleStringProperty(workNetwork);
        this.privateNetwork = new SimpleStringProperty(privateNetwork);
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

    public String getWorkNumber() {
        return workNumber.get();
    }

    public StringProperty workNumberProperty() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber.set(workNumber);
    }

    public String getPrivateNumber() {
        return privateNumber.get();
    }

    public StringProperty privateNumberProperty() {
        return privateNumber;
    }

    public void setPrivateNumber(String privateNumber) {
        this.privateNumber.set(privateNumber);
    }

    public String getWorkNetwork() {
        return workNetwork.get();
    }

    public StringProperty workNetworkProperty() {
        return workNetwork;
    }

    public void setWorkNetwork(String workNetwork) {
        this.workNetwork.set(workNetwork);
    }

    public String getPrivateNetwork() {
        return privateNetwork.get();
    }

    public StringProperty privateNetworkProperty() {
        return privateNetwork;
    }

    public void setPrivateNetwork(String privateNetwork) {
        this.privateNetwork.set(privateNetwork);
    }

    @Override
    public String saveQuery() {
        return sanitizeQuery("INSERT INTO PhoneNumbers VALUES(" + this.id + "," + this.privateNumber + "," + this.workNumber + "," + this.privateNetwork + "," + workNetwork + ")");
    }

    @Override
    public String updateQuery() {
        return sanitizeQuery("UPDATE PhoneNumbers SET ID="+this.id+ ", PrivateNumber=" + this.privateNumber + ", WorkNumber=" + this.workNumber +
                            ", PrivateNetwork="+this.privateNetwork + ", WorkNetwork="+ this.workNetwork);
    }

    @Override
    public String deleteQuery() {
        return sanitizeQuery("DELETE FROM PhoneNubmers WHERE ID=" + this.id);
    }

    @Override
    public String selectQuery() {
        return null;
    }
}
