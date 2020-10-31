package com.nc.lab1.contract;

import com.nc.lab1.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public abstract class Contract {
    private int id;
    private LocalDate startOfContract;
    private LocalDate endOfContract;
    private String contractNumber;
    private Person person;
}
