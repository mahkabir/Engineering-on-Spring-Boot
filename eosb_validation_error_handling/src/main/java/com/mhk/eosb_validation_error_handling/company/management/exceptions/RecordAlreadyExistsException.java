package com.mhk.eosb_validation_error_handling.company.management.exceptions;


import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;

public class RecordAlreadyExistsException extends CustomRootException {

    public RecordAlreadyExistsException(ResponseMessage responseMessage) {
        super(responseMessage);
    }

    public RecordAlreadyExistsException(String messageCode, String messageKey) {
        super(messageCode, messageKey);
    }
}
