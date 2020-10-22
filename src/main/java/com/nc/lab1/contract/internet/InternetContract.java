package com.nc.lab1.contract.internet;

import com.nc.lab1.contract.Contract;
import com.nc.lab1.person.Person;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class InternetContract extends Contract {
    private double speedInternet;

    public InternetContract(Long id, LocalDate startOfContract, LocalDate endOfContract, String contractNumber, Person person, double speedInternet) {
        super(id, startOfContract, endOfContract, contractNumber, person);
        this.speedInternet=speedInternet;
    }
}
