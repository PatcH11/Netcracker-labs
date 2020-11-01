package com.nc.lab1.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

/**
 * Passport description.
 * @author Nikolay Evsyukov
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode()
public class Passport {

    /**
     * Passport Series.
     */
    private int series;

    /**
     * Passport number.
     */
    private int number;
}
