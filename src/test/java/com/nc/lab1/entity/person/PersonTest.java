package com.nc.lab1.entity.person;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Testing the Person class.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class PersonTest {

    /**
     * Checking the calculation of a person's age.
     */
    @Test
    public void getAgeTest() {
        Person person = new Person(1, "Evsyukov", "Nikolay", "Eduardovich", LocalDate.of(2000, 12, 17), Gender.MAN, new Passport(1111, 12345678));
        Assert.assertEquals(19, person.getAge());
    }
}
