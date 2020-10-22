package com.nc.lab1.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode()
public class Passport {
    private int series;
    private int number;
}
