package org.jcontactmanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by mdembiczak on 11/10/17.
 */

public class PersonalContactInformation extends ContactInformation {
    private IntegerProperty id;
    private StringProperty nickname;
    private StringProperty gender;

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

    public StringProperty getNicknameProperty() {
        return nickname;
    }

    public void setNicknameProperty(StringProperty nickname) {
        this.nickname = nickname;
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

    public void setGender(StringProperty gender) {
        this.gender = gender;
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
