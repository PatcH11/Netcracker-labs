package com.nc.lab1.csv;

import com.nc.lab1.entity.contract.Contract;
import com.nc.lab1.entity.contract.tv.ChannelPackage;
import com.nc.lab1.entity.contract.tv.TvContract;
import com.nc.lab1.entity.person.Gender;
import com.nc.lab1.entity.person.Passport;
import com.nc.lab1.entity.person.Person;
import com.nc.lab1.repository.ContractRepository;
import com.nc.lab1.repository.Repository;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;

/**
 * Testing the CsvReader class.
 *
 * @author Nikolay Evsyukov
 * @version 1.1
 */
public class CsvReaderTest {

    /**
     * Checking the filling of the array.
     */
    @Test
    public void testFilling() {
        Person person = new Person(1,
                "Ferguson",
                "Eden",
                "Walker",
                LocalDate.of(2000, 12, 17),
                Gender.MAN,
                new Passport(1234, 123456));
        TvContract tvContract = new TvContract(3,
                LocalDate.of(2020, 03, 03),
                LocalDate.of(2021, 04, 04),
                "33",
                person,
                ChannelPackage.CHILD);

        Repository<Contract> contractRepository = new ContractRepository();
        CsvReader csvReader = new CsvReader();
        csvReader.filling(contractRepository, new File("src/main/resources/csv/contracts.csv"));

        Assert.assertEquals(5, contractRepository.size());
        Assert.assertEquals(tvContract.getId(), contractRepository.get(3).getId());
        Assert.assertEquals(tvContract.getStartOfContract(), contractRepository.get(3).getStartOfContract());
        Assert.assertEquals(tvContract.getEndOfContract(), contractRepository.get(3).getEndOfContract());
        Assert.assertEquals(tvContract.getContractNumber(), contractRepository.get(3).getContractNumber());
        Assert.assertEquals(tvContract.getPerson(), contractRepository.get(3).getPerson());
        TvContract tvContract1 = (TvContract) contractRepository.get(3);
        Assert.assertEquals(tvContract.getChannelPackage(), tvContract1.getChannelPackage());
    }
}
