package com.nc.lab1.contract.mobile;

import com.nc.lab1.contract.Contract;
import com.nc.lab1.person.Person;
import lombok.*;

import java.time.LocalDate;

/**
 * Description of the mobile contract.
 * @author Nikolay Evsyukov
 * @version 1.0
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class MobileContract extends Contract {

    /**
     * The number of minutes of the mobile contract.
     */
    private int minutes;

    /**
     * The number of SMS of the mobile contract.
     */
    private int sms;

    /**
     * The amount of traffic of the mobile contract.
     */
    private double trafficInternet;

    /**
     * Constructor for creating a new mobile contract.
     * @param id mobile contract ID
     * @param startOfContract the beginning of the mobile contract
     * @param endOfContract expiration of a mobile contract
     * @param contractNumber mobile contract number
     * @param person mobile contract man
     * @param minutes number of minutes of the mobile contract
     * @param sms number of SMS mobile contract
     * @param trafficInternet the amount of traffic of the mobile contract
     */
    public MobileContract(int id, LocalDate startOfContract, LocalDate endOfContract, String contractNumber, Person person, int minutes, int sms, double trafficInternet){
        super(id,startOfContract,endOfContract,contractNumber,person);
        this.minutes=minutes;
        this.sms=sms;
        this.trafficInternet=trafficInternet;
    }
}
