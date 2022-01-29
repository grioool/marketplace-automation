package by.sam_solutions.grigorieva.olga.backend.controller.exception.handler;

import by.sam_solutions.grigorieva.olga.backend.exception.AuthenticationException;
import by.sam_solutions.grigorieva.olga.backend.exception.InvalidRegistrationArgumentsException;
import by.sam_solutions.grigorieva.olga.backend.exception.UserAlreadyExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.io.IOException;

@ControllerAdvice
@Validated
public class BusinessExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @ExceptionHandler(value = {
            UserAlreadyExists.class,
            UsernameNotFoundException.class,
            AuthenticationException.class,
            InvalidRegistrationArgumentsException.class

    })
    public ResponseEntity<String> handleAuthorizationException(Exception e) {
        logError(e);
        return new ResponseEntity<>(
                e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<String> handleNotImplementedExceptions(Exception e) {
        logError(e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(value = {IOException.class})
    public ResponseEntity<String> handlerInternalExceptions(Exception e) {
        logError(e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        logError(e);
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private void logError(Exception e) {
        logger.error(e.getClass() + ": " + e.getMessage());
    }

}
