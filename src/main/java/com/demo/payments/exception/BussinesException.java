package com.demo.payments.exception;

import com.demo.payments.dto.ErrorCode;

public class BussinesException extends GenericException{


    public BussinesException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public BussinesException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
