package com.mhk.eosb_validation_error_handling.company.management.exceptions;


import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;

public class InvalidRequestDataException extends PreValidationException {

    public InvalidRequestDataException(ResponseMessage responseMessage) {
        super(responseMessage);
    }

    public InvalidRequestDataException(String messageCode, String messageKey) {
        super(messageCode, messageKey);
    }
}
