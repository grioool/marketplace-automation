package by.sam_solutions.grigorieva.olga.backend.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class UserAlreadyExists extends BusinessException {

    public UserAlreadyExists() {
        super("user.exists");
    }
}
