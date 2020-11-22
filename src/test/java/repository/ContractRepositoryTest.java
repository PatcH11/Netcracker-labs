package repository;

import com.nc.lab1.contract.Contract;
import com.nc.lab1.contract.internet.InternetContract;
import com.nc.lab1.contract.mobile.MobileContract;
import com.nc.lab1.contract.tv.ChannelPackage;
import com.nc.lab1.contract.tv.TvContract;
import com.nc.lab1.person.Gender;
import com.nc.lab1.person.Passport;
import com.nc.lab1.person.Person;
import com.nc.lab1.repository.ContractRepository;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Testing the ContractRepository class.
 *
 * @author Nikolay Evsyukov
 * @version 1.1
 */
public class ContractRepositoryTest {

    /**
     * An instance of the InternetContract class.
     */
    Contract internetContract = new InternetContract(1,
            LocalDate.of(2000, 11, 12),
            LocalDate.of(2001, 12, 13),
            "2",
            new Person(1, "a", "b", "c", LocalDate.of(1980, 01, 10), Gender.MAN, new Passport(123, 5454)),
            100.0);

    /**
     * An instance of the MobileContract class.
     */
    Contract mobileContract = new MobileContract(2,
            LocalDate.of(2010, 06, 14),
            LocalDate.of(2011, 10, 23),
            "1",
            new Person(2, "q", "f", "g", LocalDate.of(1989, 10, 12), Gender.FEMALE, new Passport(4441, 5125)),
            23,
            22,
            51.2);

    /**
     * An instance of the TvContract class.
     */
    Contract tvContract = new TvContract(3,
            LocalDate.of(2020, 11, 01),
            LocalDate.of(2021, 12, 10),
            "3",
            new Person(3, "t", "h", "s", LocalDate.of(1988, 12, 13), Gender.MAN, new Passport(1521, 552544)),
            ChannelPackage.CHILD);

    /**
     * Testing adding to the InternetContract repository.
     */
    @Test
    public void addInternetContract() {
        ContractRepository contractRepository = new ContractRepository();
        contractRepository.add(internetContract);
        Assert.assertEquals(internetContract, contractRepository.get(1));
    }

    /**
     * Testing adding to the MobileContract repository.
     */
    @Test
    public void addMobileContract() {
        ContractRepository contractRepository = new ContractRepository();
        contractRepository.add(mobileContract);
        Assert.assertEquals(mobileContract, contractRepository.get(2));
    }

    /**
     * Testing adding to the TvContract repository.
     */
    @Test
    public void addTvContract() {
        ContractRepository contractRepository = new ContractRepository();
        contractRepository.add(tvContract);
        Assert.assertEquals(tvContract, contractRepository.get(3));
    }

    /**
     * Testing removal from the InternetContract repository.
     */
    @Test
    public void deleteInternetContract() {
        ContractRepository contractRepository = new ContractRepository();
        contractRepository.add(internetContract);
        Assert.assertEquals(internetContract, contractRepository.get(1));
        contractRepository.delete(1);
        Assert.assertNull(contractRepository.get(1));
    }

    /**
     * Testing removal from the MobileContract repository.
     */
    @Test
    public void deleteMobileContract() {
        ContractRepository contractRepository = new ContractRepository();
        contractRepository.add(mobileContract);
        Assert.assertEquals(mobileContract, contractRepository.get(2));
        contractRepository.delete(2);
        Assert.assertNull(contractRepository.get(2));
    }

    /**
     * Testing deletion from TvContract repository.
     */
    @Test
    public void deleteTvContract() {
        ContractRepository contractRepository = new ContractRepository();
        contractRepository.add(tvContract);
        Assert.assertEquals(tvContract, contractRepository.get(3));
        contractRepository.delete(3);
        Assert.assertNull(contractRepository.get(3));
    }

    /**
     * Testing getting a contract by id.
     */
    @Test
    public void getContract() {
        ContractRepository contractRepository = new ContractRepository();
        contractRepository.add(internetContract);
        contractRepository.add(mobileContract);
        contractRepository.add(tvContract);
        Assert.assertEquals(mobileContract, contractRepository.get(2));
    }

    /**
     * Testing the size method.
     */
    @Test
    public void sizeRepository() {
        ContractRepository contractRepository = new ContractRepository();
        contractRepository.add(internetContract);
        contractRepository.add(mobileContract);
        contractRepository.add(tvContract);
        Assert.assertEquals(3, contractRepository.size());
    }

    /**
     * Test for receiving an array of contracts.
     */
    @Test
    public void getArrayRepository() {
        ContractRepository contractRepository = new ContractRepository();
        contractRepository.add(internetContract);
        contractRepository.add(mobileContract);
        contractRepository.add(tvContract);
        Contract[] contracts = {internetContract, mobileContract, tvContract, null, null, null, null, null, null, null};
        Assert.assertArrayEquals(contracts, contractRepository.getArray());
    }

    /**
     * Contract repository sorting test.
     */
    @Test
    public void sortRepository() {
        ContractRepository contractRepository = new ContractRepository();
        contractRepository.add(internetContract);
        contractRepository.add(mobileContract);
        contractRepository.add(tvContract);
        contractRepository.sort(((o1, o2) -> o1.getContractNumber().compareTo(o2.getContractNumber())));
        Contract[] contracts = {mobileContract, internetContract, tvContract, null, null, null, null, null, null, null};
        Contract[] contractRep = contractRepository.getArray();
        Assert.assertArrayEquals(contracts, contractRep);
    }

    /**
     * Test of searching for a contract on a certain basis.
     */
    @Test
    public void searchRepository() {
        ContractRepository contractRepository = new ContractRepository();
        contractRepository.add(internetContract);
        contractRepository.add(mobileContract);
        contractRepository.add(tvContract);
        Assert.assertEquals(internetContract, contractRepository.search(contr -> contr.getId() == 1).get(1));
    }
}
