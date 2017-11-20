package org.jcontactmanager.model;

import javafx.beans.property.StringProperty;

/**
 * Created by mdembiczak on 11/10/17.
 */

public class PersonalContactInformation extends ContactInformation {
    public StringProperty nickname;
    public StringProperty gender;

    public StringProperty getNicknameProperty() {
        return nickname;
    }

    public void setNicknameProperty(StringProperty nickname) {
        this.nickname = nickname;
    }

    public StringProperty getGenderProperty() {
        return gender;
    }

    public void setGender(StringProperty gender) {
        this.gender = gender;
    }
}
