package com.nc.lab1.contract;

import com.nc.lab1.person.Person;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InternetContract extends Contract{
    private double speedInternet;

    public InternetContract(Long id, LocalDate startOfContract, LocalDate endOfContract, String contractNumber, Person person, double speedInternet) {
        super(id, startOfContract, endOfContract, contractNumber, person);
        this.speedInternet=speedInternet;
    }
}
