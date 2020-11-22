package com.nc.lab1.contract.tv;

import com.nc.lab1.contract.Contract;
import com.nc.lab1.person.Person;
import lombok.*;

import java.time.LocalDate;

/**
 * Description of the TV contract.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TvContract extends Contract {

    /**
     * Contract channel package.
     */
    private ChannelPackage channelPackage;

    /**
     * Constructor for creating a new TV contract.
     *
     * @param id              tv contract identifier
     * @param startOfContract the beginning of the TV contract
     * @param endOfContract   the end of the TV contract
     * @param contractNumber  tv contract number
     * @param person          man tv contract
     * @param channelPackage  tv contract channel package
     */
    public TvContract(int id, LocalDate startOfContract, LocalDate endOfContract, String contractNumber, Person person, ChannelPackage channelPackage) {
        super(id, startOfContract, endOfContract, contractNumber, person);
        this.channelPackage = channelPackage;
    }
}
