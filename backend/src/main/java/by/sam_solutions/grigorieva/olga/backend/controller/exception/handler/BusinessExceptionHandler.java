package by.sam_solutions.grigorieva.olga.backend.controller.exception.handler;

import by.sam_solutions.grigorieva.olga.backend.domain.localization.Messages;
import by.sam_solutions.grigorieva.olga.backend.exception.AuthenticationException;
import by.sam_solutions.grigorieva.olga.backend.exception.InvalidRegistrationArgumentsException;
import by.sam_solutions.grigorieva.olga.backend.exception.UserAlreadyExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@ControllerAdvice
public class BusinessExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @ExceptionHandler(value = {
            UsernameNotFoundException.class,
            AuthenticationException.class,
            InvalidRegistrationArgumentsException.class
    })
    public ResponseEntity<String> handleAuthorizationException(Exception e) {
        logError(e);
        return new ResponseEntity<>(
                e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserAlreadyExists.class)
    public ResponseEntity<String> handleUserAlreadyExists(UserAlreadyExists e) {
        logError(e);
        return ResponseEntity.badRequest().body(e.getLocalizedMessage());
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

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<List<String>> handlerArgumentNotValidExceptions(MethodArgumentNotValidException e) {
        logError(e);
        List<String> localized =  e.getBindingResult().getAllErrors()
                .stream()
                .map(objectError -> Messages.getMessageForLocale(objectError.getDefaultMessage(), LocaleContextHolder.getLocale()))
                .collect(toList());
        return new ResponseEntity<>(localized, HttpStatus.BAD_REQUEST);
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
