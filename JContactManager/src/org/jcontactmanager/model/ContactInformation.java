package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/*
    For future use
 */

public abstract class ContactInformation implements IStoreable {
    protected IntegerProperty id;
    protected StringProperty name;
    protected StringProperty address;
    protected StringProperty city;
    protected StringProperty country;
    protected StringProperty note;
    protected StringProperty website;

    public int getId() {
        return id.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty getAddressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty getCityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty getCountryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
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

    public String getWebsite() {
        return website.get();
    }

    public StringProperty getWebsiteProperty() {
        return website;
    }

    public void setWebsite(String website) {
        this.website.set(website);
    }

}
