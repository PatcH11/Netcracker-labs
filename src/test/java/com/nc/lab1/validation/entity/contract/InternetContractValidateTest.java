package com.nc.lab1.validation.entity.contract;

import com.nc.lab1.entity.contract.internet.InternetContract;
import com.nc.lab1.entity.person.Gender;
import com.nc.lab1.entity.person.Passport;
import com.nc.lab1.entity.person.Person;
import com.nc.lab1.validation.ValidationResult;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Internet contracts validator test.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class InternetContractValidateTest {

    /**
     * InternetContractValidate object.
     */
    private final InternetContractValidate internetContractValidate = new InternetContractValidate();

    /**
     * A valid person.
     */
    private final Person nikolay = new Person(1, "Evsyukov", "Nikolay", "Eduardovich", LocalDate.of(2000, 12, 17), Gender.MAN, new Passport(1234, 123456));

    /**
     * Not a valid person.
     */
    private final Person testPerson = new Person(-1, "Ev2332", "Nik4343olay", "", LocalDate.of(2020, 12, 30), Gender.FEMALE, new Passport(123224, 1234876542));

    /**
     * A valid internet contract.
     */
    private final InternetContract validInternetContract = new InternetContract(1, LocalDate.of(2000, 11, 11), LocalDate.of(2001, 12, 12), "123fff", nikolay, 199.9);

    /**
     * Not a valid internet contract.
     */
    private final InternetContract invalidInternetContract = new InternetContract(0, LocalDate.of(2002, 11, 11), LocalDate.of(2001, 12, 12), "", testPerson, -12);

    /**
     * Testing the speed check of the Internet contract.
     */
    @Test
    public void checkSpeedInternetContractTest() {
        List<ValidationResult> validList = new ArrayList<>();
        List<ValidationResult> invalidList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = internetContractValidate.checkSpeedInternetContract(validInternetContract);
        validList.add(valid1);
        validList.add(valid2);

        ValidationResult invalid1 = ValidationResult.invalid("Speed internet contract invalid!");
        ValidationResult invalid2 = internetContractValidate.checkSpeedInternetContract(invalidInternetContract);
        invalidList.add(invalid1);
        invalidList.add(invalid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
        Assert.assertEquals(invalidList.get(0), invalidList.get(1));
    }

    /**
     * Testing the validity of the Internet contract.
     */
    @Test
    public void validateInternetContractTest() {
        List<ValidationResult> validList = internetContractValidate.validate(validInternetContract);
        List<ValidationResult> invalidList = internetContractValidate.validate(invalidInternetContract);

        Assert.assertTrue(internetContractValidate.isValid(validList));
        Assert.assertFalse(internetContractValidate.isValid(invalidList));
    }
}
