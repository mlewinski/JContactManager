package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by mlewinski on 11/10/17.
 */
public class Communicator {
    protected IntegerProperty id;
    protected StringProperty label;
    protected StringProperty note;
    protected StringProperty category;

    public int getId() {
        return id.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty getTypeProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
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
