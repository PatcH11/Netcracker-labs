package com.nc.lab1.contract;

import com.nc.lab1.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MobileContract extends Contract{

    private int minutes;
    private int sms;
    private double trafficInternet;

    public MobileContract(Long id, LocalDate startOfContract, LocalDate endOfContract, String contractNumber, Person person, int minutes, int sms, double trafficInternet){
        super(id,startOfContract,endOfContract,contractNumber,person);
        this.minutes=minutes;
        this.sms=sms;
        this.trafficInternet=trafficInternet;
    }
}
