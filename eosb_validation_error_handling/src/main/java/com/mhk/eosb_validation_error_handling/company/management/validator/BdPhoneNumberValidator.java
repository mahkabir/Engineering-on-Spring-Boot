package com.mhk.eosb_validation_error_handling.company.management.validator;

import com.mhk.eosb_validation_error_handling.company.management.annotations.BDPhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BdPhoneNumberValidator implements ConstraintValidator<BDPhoneNumber, String> {

    @Override
    public void initialize(BDPhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        log.info("Validating Bangladeshi Phone Number: {}", phone);
        return phone.matches("(\\+88)?01[3-9]\\d{8}");
    }
}
