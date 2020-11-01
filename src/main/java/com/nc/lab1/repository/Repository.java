package com.nc.lab1.repository;

/**
 * Description of the repository.
 * @author Nikolay Evsyukov
 * @version 1.0
 * @param <T> the type of the item in this repository
 */
public interface Repository<T> {

    /**
     * Adding an object.
     * @param item object to add
     */
    void add(T item);

    /**
     * Removing an object by its id.
     * @param id object ID
     */
    void delete(int id);

    /**
     * Getting an object by its id.
     * @param id object ID
     * @return object
     */
    T get(int id);

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    int size();
}
