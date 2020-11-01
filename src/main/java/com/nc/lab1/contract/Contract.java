package com.nc.lab1.contract;

import com.nc.lab1.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Description of the contract.
 * @author Nikolay Evsyukov
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
public abstract class Contract {

    /**
     * Contract identifier.
     */
    private int id;

    /**
     * The beginning of the contract.
     */
    private LocalDate startOfContract;

    /**
     * Termination of the contract.
     */
    private LocalDate endOfContract;

    /**
     * Contract number.
     */
    private String contractNumber;

    /**
     * Contract man.
     */
    private Person person;
}
