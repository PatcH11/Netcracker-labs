package com.nc.lab1.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test BubbleSort class.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class BubbleSortTest {

    /**
     * Sorting algorithm.
     */
    private final Sorting<Integer> sorting = new BubbleSort<>();

    /**
     * Bubble sorting test.
     */
    @Test
    public void bubbleSort() {
        Integer[] firstArray = {1, 4, 6, 1, 1, 1};
        Integer[] secondArray = {1, 1, 1, 1, 4, 6};
        sorting.sort(firstArray, (o1, o2) -> o1.compareTo(o2));
        Assert.assertArrayEquals(secondArray, firstArray);
    }
}
