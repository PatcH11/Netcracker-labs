package com.nc.lab1.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode()
public class Person {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Passport passport;

    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth,currentDate).getYears();
    }
}
