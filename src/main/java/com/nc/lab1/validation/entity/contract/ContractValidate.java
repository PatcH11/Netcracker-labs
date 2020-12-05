package com.nc.lab1.validation.entity.contract;

import com.nc.lab1.entity.contract.Contract;
import com.nc.lab1.validation.ValidationResult;
import com.nc.lab1.validation.Validator;
import com.nc.lab1.validation.entity.person.PersonValidate;

import java.util.ArrayList;
import java.util.List;

/**
 * Validation of contracts.
 *
 * @author Nikolay Evsyukov
 * @version 1.0
 */
public class ContractValidate implements Validator<Contract> {

    /**
     * PersonValidate object.
     */
    private final PersonValidate personValidate = new PersonValidate();

    /**
     * Validates the contract.
     *
     * @param param contract for verification
     * @return result of validation list
     */
    @Override
    public List<ValidationResult> validate(Contract param) {
        List<ValidationResult> results = new ArrayList<>();

        results.add(checkIdContract(param));
        results.add(checkStartOfContract(param));
        results.add(checkEndOfContract(param));
        results.add(checkNumberOfContract(param));
        results.addAll(personValidate.validate(param.getPerson()));

        return results;
    }

    /**
     * Checking the contract id.
     *
     * @param contract contract for verification
     * @return result of validation
     */
    public ValidationResult checkIdContract(Contract contract) {
        if (contract.getId() == 0 || contract.getId() < 0) {
            return ValidationResult.invalid("Id contract invalid!");
        }
        return ValidationResult.valid();
    }

    /**
     * Checking the start date of the contract.
     *
     * @param contract contract for verification
     * @return result of validation
     */
    public ValidationResult checkStartOfContract(Contract contract) {
        if (contract.getStartOfContract() == null ||
                contract.getStartOfContract().isAfter(contract.getEndOfContract())) {
            return ValidationResult.invalid("Start date contract invalid!");
        }
        return ValidationResult.valid();
    }

    /**
     * Checking the end date of the contract.
     *
     * @param contract contract for verification
     * @return result of validation
     */
    public ValidationResult checkEndOfContract(Contract contract) {
        if (contract.getEndOfContract() == null ||
                contract.getEndOfContract().isBefore(contract.getStartOfContract())) {
            return ValidationResult.invalid("End date contract invalid!");
        }
        return ValidationResult.valid();
    }

    /**
     * Checking the contract number.
     *
     * @param contract contract for verification
     * @return result of validation
     */
    public ValidationResult checkNumberOfContract(Contract contract) {
        if (contract.getContractNumber().isEmpty() || contract.getContractNumber().length() > 15) {
            return ValidationResult.invalid("Number contract invalid!");
        }
        return ValidationResult.valid();
    }
}
