package com.mhk.eosb_validation_error_handling.company.management.exceptions;


import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;

public abstract class PreValidationException extends CustomRootException {
    public PreValidationException(ResponseMessage responseMessage) {
        super(responseMessage);
    }

    public PreValidationException(String messageCode, String messageKey) {
        super(messageCode, messageKey);
    }
}
