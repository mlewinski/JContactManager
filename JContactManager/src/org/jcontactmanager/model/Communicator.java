package org.jcontactmanager.model;

import javafx.beans.property.StringProperty;

/**
 * Created by mlewinski on 11/10/17.
 */
public class Communicator {
    public StringProperty label;
    public StringProperty note;

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
