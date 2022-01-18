package by.sam_solutions.grigorieva.olga.backend.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class RegistrationException extends Exception {

    private final List<String> errors;

    public RegistrationException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

}
