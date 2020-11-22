package com.nc.lab1.repository;

import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Description of the repository.
 *
 * @param <T> the type of the item in this repository
 * @author Nikolay Evsyukov
 * @version 1.1
 */
public interface Repository<T> {

    /**
     * Adding an object.
     *
     * @param item object to add
     */
    void add(T item);

    /**
     * Removing an object by its id.
     *
     * @param id object ID
     */
    void delete(int id);

    /**
     * Getting an object by its id.
     *
     * @param id object ID
     * @return object
     */
    T get(int id);

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * Sorting the repository.
     *
     * @param comparator sorting condition
     */
    void sort(Comparator<T> comparator);

    /**
     * Search the repository.
     *
     * @param predicate search term
     * @return T repository
     */
    Repository<T> search(Predicate<T> predicate);

    /**
     * Returns an array T.
     *
     * @return T array
     */
    T[] getArray();
}
