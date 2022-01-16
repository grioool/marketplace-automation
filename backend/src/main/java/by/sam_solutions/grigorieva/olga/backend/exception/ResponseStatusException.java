package by.sam_solutions.grigorieva.olga.backend.exception;

import org.springframework.http.HttpStatus;

public class ResponseStatusException extends Exception {

    public ResponseStatusException(HttpStatus internalServerError, String responseStatusException) {
        super(internalServerError.name());
    }
}
