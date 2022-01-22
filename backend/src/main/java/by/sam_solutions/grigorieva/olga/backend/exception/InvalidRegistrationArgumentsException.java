package by.sam_solutions.grigorieva.olga.backend.exception;

public class InvalidRegistrationArgumentsException extends Exception {

    public InvalidRegistrationArgumentsException(String errorsReport) {
        super(errorsReport);
    }
}
