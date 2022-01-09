package by.sam_solutions.grigorieva.olga.backend.controller.auth.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserRegistrationDto {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String email;

    @NotEmpty
    private String nameCompany;

    @NotEmpty
    private String wbKey;

    @NotEmpty
    private String ozonKey;
}
