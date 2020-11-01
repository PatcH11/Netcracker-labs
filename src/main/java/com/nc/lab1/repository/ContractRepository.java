package com.nc.lab1.repository;

import com.nc.lab1.contract.Contract;

/**
 * Repository class for contracts.
 * @author Nikolay Evsyukov
 * @version 1.0
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
     * Constructs an empty list with an initial capacity.
     */
    public ContractRepository() {
        arrayContract = new Contract[DEFAULT_CAPACITY];
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
}
