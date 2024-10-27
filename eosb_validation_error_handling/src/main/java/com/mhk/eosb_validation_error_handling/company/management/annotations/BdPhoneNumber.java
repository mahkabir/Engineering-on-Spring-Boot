package com.mhk.eosb_validation_error_handling.company.management.annotations;

import com.mhk.eosb_validation_error_handling.company.management.validator.BdPhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BdPhoneNumberValidator.class)
public @interface BdPhoneNumber {

    String message() default "Invalid Bangladeshi Phone Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
