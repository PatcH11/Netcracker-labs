package com.nc.lab1.validation.entity.contract;

import com.nc.lab1.entity.contract.mobile.MobileContract;
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
 * Mobile contract validator test.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class MobileContractValidateTest {

    /**
     * MobileContractValidate object.
     */
    private final MobileContractValidate mobileContractValidate = new MobileContractValidate();

    /**
     * A valid person.
     */
    private final Person nikolay = new Person(1, "Evsyukov", "Nikolay", "Eduardovich", LocalDate.of(2000, 12, 17), Gender.MAN, new Passport(1234, 123456));

    /**
     * Not a valid person.
     */
    private final Person testPerson = new Person(-1, "Ev2332", "Nik4343olay", "", LocalDate.of(2020, 12, 30), Gender.FEMALE, new Passport(123224, 1234876542));

    /**
     * A valid mobile contract.
     */
    private final MobileContract validMobileContract = new MobileContract(1, LocalDate.of(2000, 11, 11), LocalDate.of(2001, 12, 12), "123fff", nikolay, 10, 12, 2.0);

    /**
     * Not a valid mobile contract.
     */
    private final MobileContract invalidMobileContract = new MobileContract(0, LocalDate.of(2002, 11, 11), LocalDate.of(2001, 12, 12), "", testPerson, -12, 0, -12);

    /**
     * Testing the minutes of the mobile contract.
     */
    @Test
    public void checkMinutesMobileContractTest() {
        List<ValidationResult> validList = new ArrayList<>();
        List<ValidationResult> invalidList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = mobileContractValidate.checkMinutesMobileContract(validMobileContract);
        validList.add(valid1);
        validList.add(valid2);

        ValidationResult invalid1 = ValidationResult.invalid("Minutes mobile contract invalid!");
        ValidationResult invalid2 = mobileContractValidate.checkMinutesMobileContract(invalidMobileContract);
        invalidList.add(invalid1);
        invalidList.add(invalid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
        Assert.assertEquals(invalidList.get(0), invalidList.get(1));
    }

    /**
     * Testing SMS mobile contract verification.
     */
    @Test
    public void checkSmsMobileContractTest() {
        List<ValidationResult> validList = new ArrayList<>();
        List<ValidationResult> invalidList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = mobileContractValidate.checkSmsMobileContract(validMobileContract);
        validList.add(valid1);
        validList.add(valid2);

        ValidationResult invalid1 = ValidationResult.invalid("Sms mobile contract invalid!");
        ValidationResult invalid2 = mobileContractValidate.checkSmsMobileContract(invalidMobileContract);
        invalidList.add(invalid1);
        invalidList.add(invalid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
        Assert.assertEquals(invalidList.get(0), invalidList.get(1));
    }

    /**
     * Testing Internet traffic verification of a mobile contract.
     */
    @Test
    public void checkTrafficInternetMobileContractTest() {
        List<ValidationResult> validList = new ArrayList<>();
        List<ValidationResult> invalidList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = mobileContractValidate.checkTrafficInternetMobileContract(validMobileContract);
        validList.add(valid1);
        validList.add(valid2);

        ValidationResult invalid1 = ValidationResult.invalid("Traffic internet mobile contract invalid!");
        ValidationResult invalid2 = mobileContractValidate.checkTrafficInternetMobileContract(invalidMobileContract);
        invalidList.add(invalid1);
        invalidList.add(invalid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
        Assert.assertEquals(invalidList.get(0), invalidList.get(1));
    }

    /**
     * Testing the validity of a mobile contract.
     */
    @Test
    public void validateMobileContractTest() {
        List<ValidationResult> validList = mobileContractValidate.validate(validMobileContract);
        List<ValidationResult> invalidList = mobileContractValidate.validate(invalidMobileContract);

        Assert.assertTrue(mobileContractValidate.isValid(validList));
        Assert.assertFalse(mobileContractValidate.isValid(invalidList));
    }
}
