package com.nc.lab1.sorting;

import java.util.Comparator;

/**
 * Description of sorting.
 *
 * @param <T>
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public interface Sorting<T> {

    /**
     * Sorting method.
     *
     * @param repository the repository to be sorted
     * @param comparator sorting condition
     */
    void sort(T[] repository, Comparator<T> comparator);
}
