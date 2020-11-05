package com.nc.lab1.sorting;

import java.util.Comparator;

/**
 * Selection sorting algorithm.
 * @author Nikolay Evsyukov
 * @version 1.0
 * @param <T>
 */
public class SelectionSort<T> implements Sorting<T>{

    /**
     * Selection sorting
     * @param repository the repository to be sorted
     * @param comparator sorting condition
     */
    @Override
    public void sort(T[] repository, Comparator<T> comparator) {
        if (repository != null && repository.length > 1) {
            int swapIndex;
            T temp;
            for (int index = 0; index < repository.length; index++) {
                T min = repository[index];
                swapIndex = index;
                for (int sub = index + 1; sub < repository.length; sub++) {
                    if(repository[sub]!=null){
                        if (comparator.compare(min, repository[sub]) > 0) {
                            min = repository[sub];
                            swapIndex = sub;
                        }
                    }
                }
                if (swapIndex != index) {
                    temp = repository[index];
                    repository[index] = repository[swapIndex];
                    repository[swapIndex] = temp;
                }
            }
        }
    }
}
