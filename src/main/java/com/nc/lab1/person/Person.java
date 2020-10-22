package com.nc.lab1.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private Long id;
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
