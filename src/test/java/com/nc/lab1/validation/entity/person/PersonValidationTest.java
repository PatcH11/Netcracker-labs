package com.nc.lab1.validation.entity.person;

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
 * Person validator testing.
 *
 * @author NIkolay Evsyukov
 * @version 1.0
 */
public class PersonValidationTest {

    /**
     * PersonValidate object.
     */
    private final PersonValidate personValidate = new PersonValidate();

    /**
     * A valid person.
     */
    private final Person nikolay = new Person(1, "Evsyukov", "Nikolay", "Eduardovich", LocalDate.of(2000, 12, 17), Gender.MAN, new Passport(1234, 123456));

    /**
     * Not a valid person.
     */
    private final Person testPerson = new Person(-1, "Ev2332", "Nik4343olay", "", LocalDate.of(2020, 12, 30), Gender.FEMALE, new Passport(123224, 1234876542));

    /**
     * Testing a person's id verification.
     */
    @Test
    public void checkIdPersonTest() {
        List<ValidationResult> validList = new ArrayList<>();
        List<ValidationResult> invalidList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = personValidate.checkIdPerson(nikolay);
        validList.add(valid1);
        validList.add(valid2);

        ValidationResult invalid1 = ValidationResult.invalid("Id person invalid!");
        ValidationResult invalid2 = personValidate.checkIdPerson(testPerson);
        invalidList.add(invalid1);
        invalidList.add(invalid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
        Assert.assertEquals(invalidList.get(0), invalidList.get(1));
    }

    /**
     * Testing a person's surname check.
     */
    @Test
    public void checkSurnamePersonTest() {
        List<ValidationResult> validList = new ArrayList<>();
        List<ValidationResult> invalidList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = personValidate.checkSurnamePerson(nikolay);
        validList.add(valid1);
        validList.add(valid2);

        ValidationResult invalid1 = ValidationResult.invalid("Surname person invalid!");
        ValidationResult invalid2 = personValidate.checkSurnamePerson(testPerson);
        invalidList.add(invalid1);
        invalidList.add(invalid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
        Assert.assertEquals(invalidList.get(0), invalidList.get(1));
    }

    /**
     * Testing the person's name.
     */
    @Test
    public void checkNamePersonTest() {
        List<ValidationResult> validList = new ArrayList<>();
        List<ValidationResult> invalidList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = personValidate.checkNamePerson(nikolay);
        validList.add(valid1);
        validList.add(valid2);

        ValidationResult invalid1 = ValidationResult.invalid("Name person invalid!");
        ValidationResult invalid2 = personValidate.checkNamePerson(testPerson);
        invalidList.add(invalid1);
        invalidList.add(invalid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
        Assert.assertEquals(invalidList.get(0), invalidList.get(1));
    }

    /**
     * Testing a person's middle name verification.
     */
    @Test
    public void checkPatronymicPersonTest() {
        List<ValidationResult> validList = new ArrayList<>();
        List<ValidationResult> invalidList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = personValidate.checkPatronymicPerson(nikolay);
        validList.add(valid1);
        validList.add(valid2);

        ValidationResult invalid1 = ValidationResult.invalid("Patronymic person invalid!");
        ValidationResult invalid2 = personValidate.checkPatronymicPerson(testPerson);
        invalidList.add(invalid1);
        invalidList.add(invalid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
        Assert.assertEquals(invalidList.get(0), invalidList.get(1));
    }

    /**
     * Testing a person's date of birth.
     */
    @Test
    public void checkDateOfBirthPersonTest() {
        List<ValidationResult> validList = new ArrayList<>();
        List<ValidationResult> invalidList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = personValidate.checkDateOfBirthPerson(nikolay);
        validList.add(valid1);
        validList.add(valid2);

        ValidationResult invalid1 = ValidationResult.invalid("Date of birth person invalid!");
        ValidationResult invalid2 = personValidate.checkDateOfBirthPerson(testPerson);
        invalidList.add(invalid1);
        invalidList.add(invalid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
        Assert.assertEquals(invalidList.get(0), invalidList.get(1));
    }

    /**
     * Testing a person's gender check.
     */
    @Test
    public void checkGenderPersonTest() {
        List<ValidationResult> validList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = personValidate.checkGenderPerson(nikolay);
        validList.add(valid1);
        validList.add(valid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
    }

    /**
     * Testing a person's passport verification.
     */
    @Test
    public void checkPassportPersonTest() {
        List<ValidationResult> validList = new ArrayList<>();
        List<ValidationResult> invalidList = new ArrayList<>();

        ValidationResult valid1 = ValidationResult.valid();
        ValidationResult valid2 = personValidate.checkPassportPerson(nikolay);
        validList.add(valid1);
        validList.add(valid2);

        ValidationResult invalid1 = ValidationResult.invalid("Passport person invalid!");
        ValidationResult invalid2 = personValidate.checkPassportPerson(testPerson);
        invalidList.add(invalid1);
        invalidList.add(invalid2);

        Assert.assertEquals(validList.get(0), validList.get(1));
        Assert.assertEquals(invalidList.get(0), invalidList.get(1));
    }

    /**
     * Person validation testing.
     */
    @Test
    public void validatePersonTest() {
        List<ValidationResult> validList = personValidate.validate(nikolay);
        List<ValidationResult> invalidList = personValidate.validate(testPerson);

        Assert.assertTrue(personValidate.isValid(validList));
        Assert.assertFalse(personValidate.isValid(invalidList));
    }
}
