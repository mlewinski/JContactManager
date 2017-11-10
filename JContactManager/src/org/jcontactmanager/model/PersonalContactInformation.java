package org.jcontactmanager.model;

public class PersonalContactInformation extends ContactInformation {
    public String nickname;
    public String gender;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
