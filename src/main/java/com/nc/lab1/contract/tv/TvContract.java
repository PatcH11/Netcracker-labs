package com.nc.lab1.contract.tv;

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
public class TvContract extends Contract {

    private ChannelPackage channelPackage;

    public TvContract(Long id, LocalDate startOfContract, LocalDate endOfContract, String contractNumber, Person person, ChannelPackage channelPackage) {
        super(id, startOfContract, endOfContract, contractNumber, person);
        this.channelPackage=channelPackage;
    }
}
