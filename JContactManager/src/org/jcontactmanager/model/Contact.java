package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import static org.jcontactmanager.util.SqlTools.sanitizeQuery;

/**
 * Created by mlewinski on 11/10/17.
 */
public class Contact implements IStoreable {
    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<Messengers> messengers = new SimpleObjectProperty<>();
    private ObjectProperty<ContactInformation> contactInformation = new SimpleObjectProperty<>();

    public Contact(int id, Messengers messengers, ContactInformation contactInformation) {
        this.setId(id);
        this.setMessengers(messengers);
        this.setContactInformation(contactInformation);
    }

    public Contact() {
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

    public Messengers getMessengers() {
        return messengers.get();
    }

    public ObjectProperty<Messengers> getMessengersProperty() {
        return messengers;
    }

    public void setMessengers(Messengers messengers){
        this.messengers.setValue(messengers);
    }

    public ContactInformation getContactInformation() {
        return contactInformation.get();
    }

    public ObjectProperty<ContactInformation> getContactInformationProperty() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation.set(contactInformation);
    }

    @Override
    public String saveQuery(){
        return sanitizeQuery("INSERT INTO Contacts VALUES('" + this.id + "','" + getContactInformation().getId()+"')");
    }

    @Override
    public String updateQuery() {
        return sanitizeQuery("UPDATE Contacts SET ID="+this.id.getValue());
    }

    @Override
    public String deleteQuery() {
        return sanitizeQuery("DELETE FROM Contacts WHERE ID =" + this.id);
    }

    @Override
    public String selectQuery() {
        return null;
    }
}
