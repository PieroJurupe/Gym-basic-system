package com.jc.gymbasicsystem.infraestructure.exceptions;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {
    private String message;
    private List<ErrorResponseFieldError> fieldErrors;


    @Data
    public static class ErrorResponseFieldError {
        private String field;
        private String error;

    }
}
