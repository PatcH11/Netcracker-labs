package com.nc.lab1.repository;

public interface Repository<T> {
    void add(T item);
    void delete(int id);
    T get(int id);
    int size();
}
