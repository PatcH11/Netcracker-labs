package com.nc.lab1.entity.contract;

import com.nc.lab1.entity.person.Person;
import lombok.*;

import java.time.LocalDate;

/**
 * Description of the contract.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
