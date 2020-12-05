package com.nc.lab1.validation;

import com.nc.lab1.entity.person.Gender;
import com.nc.lab1.entity.person.Passport;
import com.nc.lab1.entity.person.Person;
import com.nc.lab1.validation.entity.person.PersonValidate;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Validator test - isValid method.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class ValidatorTest {

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
     * Testing the isValid method.
     */
    @Test
    public void isValidTest() {
        List<ValidationResult> validList = personValidate.validate(nikolay);
        List<ValidationResult> invalidList = personValidate.validate(testPerson);

        List<ValidationResult> validationResults = new ArrayList<>();
        validationResults.add(ValidationResult.valid());
        validationResults.add(ValidationResult.valid());
        validationResults.add(ValidationResult.valid());
        validationResults.add(ValidationResult.valid());
        validationResults.add(ValidationResult.valid());
        validationResults.add(ValidationResult.valid());
        validationResults.add(ValidationResult.valid());

        List<ValidationResult> invalidResults = new ArrayList<>();
        invalidResults.add(ValidationResult.invalid("Id person invalid!"));
        invalidResults.add(ValidationResult.invalid("Surname person invalid!"));
        invalidResults.add(ValidationResult.invalid("Name person invalid!"));
        invalidResults.add(ValidationResult.invalid("Patronymic person invalid!"));
        invalidResults.add(ValidationResult.invalid("Date of birth person invalid!"));
        invalidResults.add(ValidationResult.valid());
        invalidResults.add(ValidationResult.invalid("Passport person invalid!"));

        Assert.assertEquals(validationResults, validList);
        Assert.assertEquals(invalidResults, invalidList);
    }
}
