package org.jcontactmanager.model;

import javafx.beans.property.StringProperty;

public class ContactInformation {
    public StringProperty name;
    public StringProperty address;
    public StringProperty city;
    public StringProperty country;
    public StringProperty note;
    public StringProperty website;

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
