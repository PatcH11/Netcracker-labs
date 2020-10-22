package com.nc.lab1.contract;

import com.nc.lab1.person.Person;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TvContract extends Contract{

    private ChannelPackage channelPackage;

    public TvContract(Long id, LocalDate startOfContract, LocalDate endOfContract, String contractNumber, Person person, ChannelPackage channelPackage) {
        super(id, startOfContract, endOfContract, contractNumber, person);
        this.channelPackage=channelPackage;
    }
}
