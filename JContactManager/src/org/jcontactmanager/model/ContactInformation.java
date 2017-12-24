package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
    For future use
 */

public class ContactInformation implements IStoreable {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty nickname;
    private StringProperty gender;
    private StringProperty address;
    private StringProperty city;
    private StringProperty country;
    private StringProperty note;
    private StringProperty website;

    public ContactInformation() {
        this(0,null,null,null,null,null,null,null,null);
    }

    public ContactInformation(int id, String name, String nickname, String gender, String address, String city, String country, String note, String website) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.nickname = new SimpleStringProperty(nickname);
        this.gender = new SimpleStringProperty(gender);
        this.address = new SimpleStringProperty(address);
        this.city = new SimpleStringProperty(city);
        this.country = new SimpleStringProperty(country);
        this.note = new SimpleStringProperty(note);
        this.website = new SimpleStringProperty(website);
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
    public StringProperty getNicknameProperty() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname.setValue(nickname);
    }

    public String getNickname() {
        return nickname.get();
    }


    public String getGender() {
        return gender.get();
    }

    public StringProperty getGenderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.setValue(gender);
    }

    @Override
    public String saveQuery() {
        return null;
    }

    @Override
    public String updateQuery() {
        return null;
    }

    @Override
    public String deleteQuery() {
        return null;
    }

    @Override
    public String selectQuery() {
        return null;
    }

}
