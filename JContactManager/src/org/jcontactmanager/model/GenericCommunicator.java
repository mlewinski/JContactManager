package org.jcontactmanager.model;

/**
 * Created by mlewinski on 11/10/17.
 */
public class GenericCommunicator extends Communicator{
    public String address;
    public String protocol;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
