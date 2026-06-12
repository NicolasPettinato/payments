package com.demo.payments.exception;

import com.demo.payments.dto.ErrorCode;
import com.demo.payments.dto.ErrorResponse;
import com.demo.payments.mapper.ObjectConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<ErrorResponse> technicalException(TechnicalException ex) {
        var errorResponse = getErrorResponse(ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> bussinessException(BusinessException ex) {
        var errorResponse = getErrorResponse(ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var message = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        log.error(ex.getMessage(), ex);

        var errorResponse = ErrorResponse.builder()
                .code(ErrorCode.BAD_REQUEST.toString())
                .message(message)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(DataAccessException ex) {
        log.error(ex.getMessage(), ex);

        var errorResponse = ErrorResponse.builder()
                .code(ErrorCode.INTERNAL_ERROR.toString())
                .message("Error interno del servicio")
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    private static ErrorResponse getErrorResponse(GenericException ex) {
        log.error(ex.getMessage(), ex);

        return ErrorResponse.builder()
                .code(ex.getErrorCode().toString())
                .message(ex.getMessage())
                .build();
    }
}
