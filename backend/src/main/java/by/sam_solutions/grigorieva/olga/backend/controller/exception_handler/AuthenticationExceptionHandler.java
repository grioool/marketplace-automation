package by.sam_solutions.grigorieva.olga.backend.controller.exception_handler;

import by.sam_solutions.grigorieva.olga.backend.controller.auth.AuthController;
import by.sam_solutions.grigorieva.olga.backend.exception.RegistrationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = {AuthController.class})
public class AuthenticationExceptionHandler {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<List<String>> handleRegistrationException(RegistrationException exception) {
        return ResponseEntity
                .badRequest()
                .body(exception.getErrors());
    }

}
