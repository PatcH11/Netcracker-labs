package com.nc.lab1.validation.entity.contract;

import com.nc.lab1.entity.contract.internet.InternetContract;
import com.nc.lab1.validation.ValidationResult;
import com.nc.lab1.validation.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Validation of internet contracts.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class InternetContractValidate implements Validator<InternetContract> {

    /**
     * ContractValidate object.
     */
    private final ContractValidate contractValidate = new ContractValidate();

    /**
     * Validates the internet contract.
     *
     * @param param internet contract for verification
     * @return result of validation list
     */
    @Override
    public List<ValidationResult> validate(InternetContract param) {
        List<ValidationResult> results = new ArrayList<>();

        results.add(checkSpeedInternetContract(param));
        results.addAll(contractValidate.validate(param));

        return results;
    }

    /**
     * Checking the speed in the Internet contract.
     *
     * @param internetContract internet contract for verification
     * @return result of validation
     */
    public ValidationResult checkSpeedInternetContract(InternetContract internetContract) {
        if (internetContract.getSpeedInternet() == 0 || internetContract.getSpeedInternet() < 0) {
            return ValidationResult.invalid("Speed internet contract invalid!");
        }
        return ValidationResult.valid();
    }
}
