package by.sam_solutions.grigorieva.olga.backend.controller.auth_registration;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AuthRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
