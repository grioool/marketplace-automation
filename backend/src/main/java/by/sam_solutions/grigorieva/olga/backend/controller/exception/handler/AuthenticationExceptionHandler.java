package by.sam_solutions.grigorieva.olga.backend.controller.exception.handler;

import by.sam_solutions.grigorieva.olga.backend.controller.registration.RegistrationController;
import by.sam_solutions.grigorieva.olga.backend.exception.RegistrationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = {RegistrationController.class})
public class AuthenticationExceptionHandler {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<List<String>> handleRegistrationException(RegistrationException exception) {
        return ResponseEntity
                .badRequest()
                .body(exception.getErrors());
    }
}
