package com.nc.lab1.validation.entity.contract;

import com.nc.lab1.entity.contract.mobile.MobileContract;
import com.nc.lab1.validation.ValidationResult;
import com.nc.lab1.validation.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Validation of mobile contracts.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class MobileContractValidate implements Validator<MobileContract> {

    /**
     * ContractValidate object.
     */
    private final ContractValidate contractValidate = new ContractValidate();

    /**
     * Validates the mobile contract.
     *
     * @param param mobile contract for verification
     * @return result of validation list
     */
    @Override
    public List<ValidationResult> validate(MobileContract param) {
        List<ValidationResult> results = new ArrayList<>();

        results.add(checkMinutesMobileContract(param));
        results.add(checkSmsMobileContract(param));
        results.add(checkTrafficInternetMobileContract(param));
        results.addAll(contractValidate.validate(param));

        return results;
    }

    /**
     * Checking minutes in a mobile contract.
     *
     * @param mobileContract mobile contract for verification
     * @return result of validation
     */
    public ValidationResult checkMinutesMobileContract(MobileContract mobileContract) {
        if (mobileContract.getMinutes() == 0 || mobileContract.getMinutes() < 0) {
            return ValidationResult.invalid("Minutes mobile contract invalid!");
        }
        return ValidationResult.valid();
    }

    /**
     * SMS verification in a mobile contract.
     *
     * @param mobileContract mobile contract for verification
     * @return result of validation
     */
    public ValidationResult checkSmsMobileContract(MobileContract mobileContract) {
        if (mobileContract.getSms() == 0 || mobileContract.getSms() < 0) {
            return ValidationResult.invalid("Sms mobile contract invalid!");
        }
        return ValidationResult.valid();
    }

    /**
     * Checking Internet traffic in a mobile contract.
     *
     * @param mobileContract mobile contract for verification
     * @return result of validation
     */
    public ValidationResult checkTrafficInternetMobileContract(MobileContract mobileContract) {
        if (mobileContract.getTrafficInternet() == 0 || mobileContract.getTrafficInternet() < 0) {
            return ValidationResult.invalid("Traffic internet mobile contract invalid!");
        }
        return ValidationResult.valid();
    }
}
