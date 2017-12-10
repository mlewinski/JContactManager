package org.jcontactmanager.model;

import java.sql.ResultSet;

/**
 * Interface for objects that are capable of being created with provision of java.sql.ResultSet as a values source.
 * @param <T> Type of the object to be created
 */
public interface IBuildable<T> {
    /**
     * Create object from a set of values
     * @param set ResultSet containing values used to initialize the created object
     * @return Reference to the newly created object
     */
    public T buildObject(ResultSet set);
}
