package com.nc.lab1.validation;

import java.util.List;

/**
 * Description of the validator.
 *
 * @param <T> object
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public interface Validator<T> {

    /**
     * Object validation.
     *
     * @param param object
     * @return result of validation list
     */
    List<ValidationResult> validate(T param);

    /**
     * Checking for validity.
     *
     * @param results ValidationResult list
     * @return is the list valid
     */
    default boolean isValid(List<ValidationResult> results) {
        for (ValidationResult validationResult : results) {
            if (validationResult.getStatus() == ValidationStatus.ERROR) {
                return false;
            }
        }
        return true;
    }
}
