package org.jcontactmanager.model;

public class CorporateContactInformation extends ContactInformation {
    public String NIP;
    public String REGON;

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getREGON() {
        return REGON;
    }

    public void setREGON(String REGON) {
        this.REGON = REGON;
    }

}
