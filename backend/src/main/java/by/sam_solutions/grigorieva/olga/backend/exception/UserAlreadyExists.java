package by.sam_solutions.grigorieva.olga.backend.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class UserAlreadyExists extends BusinessException {

    private final List<String> errors;

    public UserAlreadyExists(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }
}
