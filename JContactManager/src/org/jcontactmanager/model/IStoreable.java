package org.jcontactmanager.model;

/**
 * Interface for objects serializable to database. Declares methods that provide an SQL code used to manage the object's state within a database.
 * @author Marek
 * @version 10.12.2017 *
 */

public interface IStoreable {
    /**
     * Describes how to store the object in a database
     * @return DML query used to store the object
     */
    public String saveQuery();

    /**
     * Describes how to update the object's state in a database
     * @return DML query used to update the object's state
     */
    public String updateQuery();

    /**
     * Describes how to delete the object from a database
     * @return DML query used to delete the object
     */
    public String deleteQuery();

    /**
     * Describes how to retrieve the object from a database
     * @return DML query used to retrieve the object
     */
    public String selectQuery();
}
