package com.demo.payments.exception;

import com.demo.payments.dto.ErrorCode;

public class BusinessException extends GenericException{


    public BusinessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public BusinessException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
