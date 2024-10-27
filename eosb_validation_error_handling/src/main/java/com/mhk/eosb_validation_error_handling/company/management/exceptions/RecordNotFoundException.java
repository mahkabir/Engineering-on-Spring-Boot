package com.mhk.eosb_validation_error_handling.company.management.exceptions;


import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;

public class RecordNotFoundException extends CustomRootException {

    public RecordNotFoundException(ResponseMessage responseMessage) {
        super(responseMessage);
    }

    public RecordNotFoundException(String messageCode, String messageKey) {
        super(messageCode, messageKey);
    }
}
