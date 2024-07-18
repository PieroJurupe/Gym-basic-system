package com.jc.gymbasicsystem.infraestructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Validation failed");

        List<ErrorResponse.ErrorResponseFieldError> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> {
                    ErrorResponse.ErrorResponseFieldError error = new ErrorResponse.ErrorResponseFieldError();
                    error.setField(fieldError.getField());
                    error.setError(fieldError.getDefaultMessage());
                    return error;
                })
                .collect(Collectors.toList());

        errorResponse.setFieldErrors(fieldErrors);
        return errorResponse;
    }
}
