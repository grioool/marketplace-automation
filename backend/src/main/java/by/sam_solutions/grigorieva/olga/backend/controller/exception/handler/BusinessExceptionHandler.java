package by.sam_solutions.grigorieva.olga.backend.controller.exception.handler;

import by.sam_solutions.grigorieva.olga.backend.exception.AuthenticationException;
import by.sam_solutions.grigorieva.olga.backend.exception.InvalidRegistrationArgumentsException;
import by.sam_solutions.grigorieva.olga.backend.exception.UserAlreadyExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.List;

@ControllerAdvice
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
                e.getMessage(), HttpStatus.FORBIDDEN);
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

    private void logError(Exception e) {
        logger.error(e.getClass() + ": " + e.getMessage());
    }

}
