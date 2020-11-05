package com.nc.lab1.repository;

import com.nc.lab1.contract.Contract;
import com.nc.lab1.sorting.SelectionSort;
import com.nc.lab1.sorting.Sorting;

import java.util.*;
import java.util.function.Predicate;

/**
 * Repository class for contracts.
 * @author Nikolay Evsyukov
 * @version 1.1
 */
public class ContractRepository implements Repository<Contract> {

    /**
     * Initial size of the array.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The number of elements contained in the array.
     */
    private int size = 0;

    /**
     * Array for storing contracts.
     */
    private Contract[] arrayContract;

    /**
     * Sorting the repository.
     */
    private final Sorting<Contract> sorting;

    /**
     * Constructs an empty list with an initial capacity.
     */
    public ContractRepository() {
        arrayContract = new Contract[DEFAULT_CAPACITY];
        sorting = new SelectionSort<>();;
    }

    /**
     * Increase the size of the array.
     */
    private void resize(){
        Contract[] newArray = new Contract[arrayContract.length+10];
        System.arraycopy(arrayContract,0,newArray,0,size);
        arrayContract = newArray;
    }

    /**
     * Adding a contract to the repository.
     * @param item contract to add
     */
    @Override
    public void add(Contract item) {
        if(size == arrayContract.length-1){
            resize();
        }
        arrayContract[size++] = item;
    }

    /**
     * Deleting a contract by its id.
     * @param id contract ID
     */
    @Override
    public void delete(int id) {
        for (int i = 0; i < size; i++){
            if(arrayContract[i].getId() == id){
                arrayContract[i] = arrayContract[i+1];
                size--;
            }
        }
    }

    /**
     * Receiving a contract by its id.
     * @param id contract ID
     * @return contract
     */
    @Override
    public Contract get(int id) {
        for (int i = 0; i < size; i++){
            if(arrayContract[i].getId() == id){
                return arrayContract[i];
            }
        }
        return null;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Sorting the repository.
     * @param comparator sorting condition
     */
    @Override
    public void sort(Comparator<Contract> comparator) {
        sorting.sort(arrayContract,comparator);
    }

    /**
     * Search the repository.
     * @param predicate search term
     * @return contract repository
     */
    @Override
    public Repository<Contract> search(Predicate<Contract> predicate) {
        Repository<Contract> repository = new ContractRepository();
        for(int i = 0; i < size; i++){
            if(arrayContract[i] != null){
                Contract contract = arrayContract[i];
                if(predicate.test(contract)){
                    repository.add(contract);
                }
            }
        }
        return repository;
    }

    /**
     * Returns an array of current contracts.
     * @return array of contracts
     */
    @Override
    public Contract[] getArray() {
        return arrayContract;
    }
}
