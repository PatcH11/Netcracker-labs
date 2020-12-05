package com.nc.lab1.validation.entity.person;

import com.nc.lab1.entity.person.Person;
import com.nc.lab1.validation.ValidationResult;
import com.nc.lab1.validation.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Validation of person.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class PersonValidate implements Validator<Person> {

    /**
     * Validates the person.
     *
     * @param param person for verification
     * @return result of validation list
     */
    @Override
    public List<ValidationResult> validate(Person param) {
        List<ValidationResult> results = new ArrayList<>();

        results.add(checkIdPerson(param));
        results.add(checkSurnamePerson(param));
        results.add(checkNamePerson(param));
        results.add(checkPatronymicPerson(param));
        results.add(checkDateOfBirthPerson(param));
        results.add(checkGenderPerson(param));
        results.add(checkPassportPerson(param));

        return results;
    }

    /**
     * Checking a person's id.
     *
     * @param person person for verification
     * @return result of validation
     */
    public ValidationResult checkIdPerson(Person person) {
        if (person.getId() == 0 || person.getId() < 0) {
            return ValidationResult.invalid("Id person invalid!");
        }
        return ValidationResult.valid();
    }

    /**
     * Checking the person's surname.
     *
     * @param person person for verification
     * @return result of validation
     */
    public ValidationResult checkSurnamePerson(Person person) {
        if (person.getSurname().isEmpty() || person.getSurname().matches(".*\\d+.*")) {
            return ValidationResult.invalid("Surname person invalid!");
        }
        return ValidationResult.valid();
    }

    /**
     * Checking the person's name.
     *
     * @param person person for verification
     * @return result of validation
     */
    public ValidationResult checkNamePerson(Person person) {
        if (person.getName().isEmpty() || person.getName().matches(".*\\d+.*")) {
            return ValidationResult.invalid("Name person invalid!");
        }
        return ValidationResult.valid();
    }

    /**
     * Checking the person's middle name.
     *
     * @param person person for verification
     * @return result of validation
     */
    public ValidationResult checkPatronymicPerson(Person person) {
        if (person.getPatronymic().isEmpty() || person.getPatronymic().matches(".*\\d+.*")) {
            return ValidationResult.invalid("Patronymic person invalid!");
        }
        return ValidationResult.valid();
    }

    /**
     * Checking the person's date of birth.
     *
     * @param person person for verification
     * @return result of validation
     */
    public ValidationResult checkDateOfBirthPerson(Person person) {
        if (person.getDateOfBirth() == null || person.getDateOfBirth().isAfter(LocalDate.now())) {
            return ValidationResult.invalid("Date of birth person invalid!");
        }
        return ValidationResult.valid();
    }

    /**
     * Checking a person's gender.
     *
     * @param person person for verification
     * @return result of validation
     */
    public ValidationResult checkGenderPerson(Person person) {
        if (person.getGender() == null) {
            return ValidationResult.invalid("Gender person invalid!");
        }
        return ValidationResult.valid();
    }

    /**
     * Checking a person's passport.
     *
     * @param person person for verification
     * @return result of validation
     */
    public ValidationResult checkPassportPerson(Person person) {
        if (person.getPassport() == null ||
                person.getPassport().getNumber() == 0 ||
                person.getPassport().getNumber() < 0 ||
                String.valueOf(person.getPassport().getNumber()).length() > 6 ||
                person.getPassport().getSeries() == 0 ||
                person.getPassport().getSeries() < 0 ||
                String.valueOf(person.getPassport().getSeries()).length() > 4) {
            return ValidationResult.invalid("Passport person invalid!");
        }
        return ValidationResult.valid();
    }
}
