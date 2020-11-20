package com.nc.lab1.contract.internet;

import com.nc.lab1.contract.Contract;
import com.nc.lab1.person.Person;
import lombok.*;

import java.time.LocalDate;

/**
 * Description of the Internet contract.
 * @author Nikolay Evsyukov
 * @version 1.0
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InternetContract extends Contract {

    /**
     * Internet contract connection speed.
     */
    private double speedInternet;

    /**
     * Constructor for creating a new Internet contract.
     * @param id internet contract identifier
     * @param startOfContract the beginning of the Internet contract
     * @param endOfContract expiration of the Internet contract
     * @param contractNumber internet contract number
     * @param person internet contract man
     * @param speedInternet internet contract connection speed
     */
    public InternetContract(int id, LocalDate startOfContract, LocalDate endOfContract, String contractNumber, Person person, double speedInternet) {
        super(id, startOfContract, endOfContract, contractNumber, person);
        this.speedInternet=speedInternet;
    }
}
