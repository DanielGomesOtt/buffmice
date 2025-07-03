package com.danielott.BackendBuffMice.exceptions;

public class UserRegisterValidationException extends RuntimeException{

    public UserRegisterValidationException(String message) {
        super(message);
    }
}
