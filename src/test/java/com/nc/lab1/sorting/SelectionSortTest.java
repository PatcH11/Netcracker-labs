package com.nc.lab1.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test SelectionSort class.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class SelectionSortTest {

    /**
     * Sorting algorithm.
     */
    private final Sorting<Integer> sorting = new SelectionSort<>();

    /**
     * Selection sorting test.
     */
    @Test
    public void selectionSort() {
        Integer[] firstArray = {5, 16, 82, 2, 5};
        Integer[] secondArray = {2, 5, 5, 16, 82};
        sorting.sort(firstArray, (o1, o2) -> o1.compareTo(o2));
        Assert.assertArrayEquals(secondArray, firstArray);
    }
}
