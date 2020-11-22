package com.nc.lab1.sorting;

import java.util.Comparator;

/**
 * Bubble sorting algorithm.
 *
 * @param <T>
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class BubbleSort<T> implements Sorting<T> {

    /**
     * Bubble sorting.
     *
     * @param repository the repository to be sorted
     * @param comparator sorting condition
     */
    @Override
    public void sort(T[] repository, Comparator<T> comparator) {
        if (repository != null && repository.length > 1) {
            for (int i = 1; i < repository.length; i++) {
                for (int j = 0; j < repository.length; j++) {
                    if (repository[i] != null) {
                        if (comparator.compare(repository[i], repository[j]) < 0) {
                            swap(repository, i, j);
                        }
                    }
                }
            }
        }
    }

    /**
     * Replacement of elements.
     *
     * @param repository the repository to be sorted
     * @param i          the element to be changed
     * @param j          the element to be changed to
     */
    private void swap(T[] repository, int i, int j) {
        T obj = repository[i];
        repository[i] = repository[j];
        repository[j] = obj;
    }
}
