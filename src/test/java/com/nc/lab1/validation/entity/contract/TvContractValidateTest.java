package com.nc.lab1.validation.entity.contract;

import com.nc.lab1.entity.contract.tv.ChannelPackage;
import com.nc.lab1.entity.contract.tv.TvContract;
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
 * Tv contracts validator test.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class TvContractValidateTest {

    /**
     * TvContractValidate object.
     */
    private final TvContractValidate tvContractValidate = new TvContractValidate();

    /**
     * A valid person.
     */
    private final Person nikolay = new Person(1, "Evsyukov", "Nikolay", "Eduardovich", LocalDate.of(2000, 12, 17), Gender.MAN, new Passport(1234, 123456));

    /**
     * Not a valid person.
     */
    private final Person testPerson = new Person(-1, "Ev2332", "Nik4343olay", "", LocalDate.of(2020, 12, 30), Gender.FEMALE, new Passport(123224, 1234876542));

    /**
     * A valid tv contract.
     */
    private final TvContract validTvContract = new TvContract(1, LocalDate.of(2000, 11, 11), LocalDate.of(2001, 12, 12), "123fff", nikolay, ChannelPackage.CHILD);

    /**
     * Not a valid tv contract.
     */
    private final TvContract invalidTvContract = new TvContract(0, LocalDate.of(2002, 11, 11), LocalDate.of(2001, 12, 12), "", testPerson, ChannelPackage.EXTRA);

    /**
     * Testing the verification of a package of channels.
     */
    @Test
    public void checkChannelPackageTvContractTest() {
        List<ValidationResult> validList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = tvContractValidate.checkChannelPackageTvContract(validTvContract);
        validList.add(valid1);
        validList.add(valid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
    }

    /**
     * Testing the validity of the TV contract.
     */
    @Test
    public void validateTvContractTest() {
        List<ValidationResult> validList = tvContractValidate.validate(validTvContract);
        List<ValidationResult> invalidList = tvContractValidate.validate(invalidTvContract);

        Assert.assertTrue(tvContractValidate.isValid(validList));
        Assert.assertFalse(tvContractValidate.isValid(invalidList));
    }
}
