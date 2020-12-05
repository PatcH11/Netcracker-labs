package com.nc.lab1.validation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Validation result.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ValidationResult {

    /**
     * Validation status.
     */
    private ValidationStatus status;
    /**
     * Validation message.
     */
    private String messageInfo;

    /**
     * The item is valid.
     *
     * @return result of validation
     */
    public static ValidationResult valid() {
        return new ValidationResult(ValidationStatus.OK, "Valid!");
    }

    /**
     * The item is not valid.
     *
     * @param messageInfo validation message
     * @return result of validation
     */
    public static ValidationResult invalid(String messageInfo) {
        return new ValidationResult(ValidationStatus.ERROR, messageInfo);
    }
}
