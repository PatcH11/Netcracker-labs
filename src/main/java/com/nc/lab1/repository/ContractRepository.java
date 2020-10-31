package com.nc.lab1.repository;

import com.nc.lab1.contract.Contract;

public class ContractRepository implements Repository<Contract> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Contract[] arrayContract;

    public ContractRepository() {
        arrayContract = new Contract[DEFAULT_CAPACITY];
    }

    private void resize(){
        Contract[] newArray = new Contract[arrayContract.length+10];
        System.arraycopy(arrayContract,0,newArray,0,size);
        arrayContract = newArray;
    }

    @Override
    public void add(Contract item) {
        if(size == arrayContract.length-1){
            resize();
        }
        arrayContract[size++] = item;
    }

    @Override
    public void delete(int id) {
        if (id < 0 || id >= size){
            System.out.println("There is no element under this id");
        }
        for (int i = id; i < size; i++){
            arrayContract[i] = arrayContract[i+1];
        }
        size--;
    }

    @Override
    public Contract get(int id) {
        if (id < 0 || id >= size){
            System.out.println("There is no element under this id");
            return null;
        }
        return arrayContract[id];
    }

    @Override
    public int size() {
        return size;
    }
}
