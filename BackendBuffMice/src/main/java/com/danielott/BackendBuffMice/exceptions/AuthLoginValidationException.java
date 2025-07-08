package com.danielott.BackendBuffMice.exceptions;

public class AuthLoginValidationException extends RuntimeException {
    public AuthLoginValidationException(String message) {
        super(message);
    }
}
