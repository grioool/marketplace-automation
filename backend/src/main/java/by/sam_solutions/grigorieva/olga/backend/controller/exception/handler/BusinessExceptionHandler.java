package by.sam_solutions.grigorieva.olga.backend.controller.exception.handler;

import by.sam_solutions.grigorieva.olga.backend.domain.localization.Messages;
import by.sam_solutions.grigorieva.olga.backend.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.io.IOException;

@ControllerAdvice
public class BusinessExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(BusinessExceptionHandler.class);
    private final String errorHeader = "error";

    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity<String> handleAuthorizationException(AuthenticationException e) {
        logError(e);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).header(errorHeader, e.getLocalizedMessage()).build();
    }

    @ExceptionHandler(value = UsernameAlreadyExists.class)
    public ResponseEntity<String> handleUserAlreadyExists(UsernameAlreadyExists e) {
        logError(e);
        return ResponseEntity.badRequest().header(errorHeader, e.getLocalizedMessage()).build();
    }

    @ExceptionHandler(value = EmailAlreadyExists.class)
    public ResponseEntity<String> handleEmailAlreadyExists(EmailAlreadyExists e) {
        logError(e);
        return ResponseEntity.badRequest().header(errorHeader, e.getLocalizedMessage()).build();
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException e) {
        logError(e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(errorHeader,e.getLocalizedMessage()).build();
    }

    @ExceptionHandler(value = TokenException.class)
    public ResponseEntity<String> handleTokenInvalid(TokenException e) {
        logError(e);
        return ResponseEntity.badRequest().header(errorHeader, e.getLocalizedMessage()).build();
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<String> handleNotImplementedExceptions(HttpRequestMethodNotSupportedException e) {
        logError(e);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).header(errorHeader, e.getLocalizedMessage()).build();
    }

    @ExceptionHandler(value = {IOException.class})
    public ResponseEntity<String> handlerInternalExceptions(IOException e) {
        logError(e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(errorHeader, e.getMessage()).build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        logError(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).header(errorHeader, e.getMessage()).build();
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException e) {
        logError(e);
        return ResponseEntity.badRequest().header("error", Messages.getMessage("bad.credentials")).build();
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException e) {
        logError(e);
        return ResponseEntity.badRequest().header("error", Messages.getMessage("bad.credentials")).build();
    }

   // @ExceptionHandler(value = {HttpStatus.UPGRADE_REQUIRED})
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    public ResponseEntity<String> handleBadCredentialsException(UsernameNotFoundException e) {
        logError(e);
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).header("error", Messages.getMessage("upgrade.required")).build();
    }

    private void logError(Exception e) {
        logger.error(e.getClass() + ": " + e.getMessage());
    }

}
