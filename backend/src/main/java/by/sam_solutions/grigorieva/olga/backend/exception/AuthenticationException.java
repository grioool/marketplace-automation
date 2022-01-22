package by.sam_solutions.grigorieva.olga.backend.exception;

public class AuthenticationException extends Exception {
    public AuthenticationException(String errorsReport) {
        super(errorsReport);
    }
}
