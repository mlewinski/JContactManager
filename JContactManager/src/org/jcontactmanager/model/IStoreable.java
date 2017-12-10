package org.jcontactmanager.model;

public interface IStoreable {
    public String saveQuery();
    public String updateQuery();
    public String deleteQuery();
    public String selectQuery();
}
