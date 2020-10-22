package com.nc.lab1.contract;

import com.nc.lab1.person.Person;

import java.time.LocalDate;

public abstract class Contract {
    private Long id;
    private LocalDate startOfContract;
    private LocalDate endOfContract;
    private String contractNumber;
    private Person person;
}
