package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by mlewinski on 11/10/17.
 */
public abstract class Communicator implements IStoreable {
    protected IntegerProperty id = new SimpleIntegerProperty();
    protected IntegerProperty ownerID = new SimpleIntegerProperty();
    protected StringProperty label = new SimpleStringProperty();
    protected StringProperty note = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }


    public String getLabel() {
        return label.get();
    }

    public StringProperty getLabelProperty() {
        return label;
    }

    public void setLabel(String label) {
        this.label.set(label);
    }

    public String getNote() {
        return note.get();
    }

    public StringProperty getNoteProperty() {
        return note;
    }

    public void setNote(String note) {
        this.note.set(note);
    }

}
