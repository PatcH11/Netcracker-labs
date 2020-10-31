package com.nc.lab1.contract.mobile;

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
public class MobileContract extends Contract {

    private int minutes;
    private int sms;
    private double trafficInternet;

    public MobileContract(int id, LocalDate startOfContract, LocalDate endOfContract, String contractNumber, Person person, int minutes, int sms, double trafficInternet){
        super(id,startOfContract,endOfContract,contractNumber,person);
        this.minutes=minutes;
        this.sms=sms;
        this.trafficInternet=trafficInternet;
    }
}
