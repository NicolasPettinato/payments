package com.demo.payments.exception;

import com.demo.payments.dto.ErrorCode;

public class TechnicalException extends GenericException {

    public TechnicalException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public TechnicalException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
