package com.nc.lab1.validation.entity.contract;

import com.nc.lab1.entity.contract.tv.TvContract;
import com.nc.lab1.validation.ValidationResult;
import com.nc.lab1.validation.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Validation of tv contracts.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class TvContractValidate implements Validator<TvContract> {

    /**
     * ContractValidate object.
     */
    private final ContractValidate contractValidate = new ContractValidate();

    /**
     * Validates the tv contract.
     *
     * @param param tv contract for verification
     * @return result of validation list
     */
    @Override
    public List<ValidationResult> validate(TvContract param) {
        List<ValidationResult> results = new ArrayList<>();

        results.add(checkChannelPackageTvContract(param));
        results.addAll(contractValidate.validate(param));

        return results;
    }

    /**
     * Checking the package of channels in the tv contract.
     *
     * @param tvContract tv contract for verification
     * @return result of validation
     */
    public ValidationResult checkChannelPackageTvContract(TvContract tvContract) {
        if (tvContract.getChannelPackage() == null) {
            return ValidationResult.invalid("Channel package tv contract invalid!");
        }
        return ValidationResult.valid();
    }
}
