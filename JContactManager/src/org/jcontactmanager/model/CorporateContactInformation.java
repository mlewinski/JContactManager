package org.jcontactmanager.model;

import javafx.beans.property.StringProperty;

public class CorporateContactInformation extends ContactInformation {
    private StringProperty NIP;
    private StringProperty REGON;

    public String getNIP() {
        return NIP.get();
    }

    public StringProperty getNIPProperty() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP.set(NIP);
    }

    public String getREGON() {
        return REGON.get();
    }

    public StringProperty getREGONProperty() {
        return REGON;
    }

    public void setREGON(String REGON) {
        this.REGON.set(REGON);
    }

}
