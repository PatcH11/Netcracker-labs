package com.nc.lab1.entity.person;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;

/**
 * Description of a person.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode()
public class Person {

    /**
     * Person ID.
     */
    private int id;

    /**
     * The last name of the person.
     */
    private String surname;

    /**
     * The name of the person.
     */
    private String name;

    /**
     * Patronymic of the person.
     */
    private String patronymic;

    /**
     * Date of birth of the person.
     */
    private LocalDate dateOfBirth;

    /**
     * Human gender.
     */
    private Gender gender;

    /**
     * Person's passport.
     */
    private Passport passport;

    /**
     * The age of the person.
     *
     * @return age
     */
    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }
}
