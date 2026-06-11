package com.demo.payments.exception;

import com.demo.payments.dto.ErrorCode;
import lombok.Getter;

@Getter
public class GenericException extends RuntimeException{

    private final ErrorCode errorCode;

    public GenericException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public GenericException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
