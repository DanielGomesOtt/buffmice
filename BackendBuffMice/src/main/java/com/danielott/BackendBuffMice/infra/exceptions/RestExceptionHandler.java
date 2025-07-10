package com.danielott.BackendBuffMice.infra.exceptions;

import com.danielott.BackendBuffMice.exceptions.AuthLoginValidationException;
import com.danielott.BackendBuffMice.exceptions.ExerciseObservationCreationException;
import com.danielott.BackendBuffMice.exceptions.TrainingCreationException;
import com.danielott.BackendBuffMice.exceptions.UserRegisterValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserRegisterValidationException.class)
    private ResponseEntity<RestErrorMessage> userRegisterValidationException (UserRegisterValidationException exception) {
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(AuthLoginValidationException.class)
    private ResponseEntity<RestErrorMessage> authLoginValidationException (AuthLoginValidationException exception) {
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    private ResponseEntity<RestErrorMessage> badCredentialsException (BadCredentialsException exception) {
        RestErrorMessage response = new RestErrorMessage(HttpStatus.UNAUTHORIZED, "Invalid username or password.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(TrainingCreationException.class)
    private ResponseEntity<RestErrorMessage> trainingCreationException (TrainingCreationException exception) {
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ExerciseObservationCreationException.class)
    private ResponseEntity<RestErrorMessage> exerciseObservationCreationException (ExerciseObservationCreationException exception) {
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
