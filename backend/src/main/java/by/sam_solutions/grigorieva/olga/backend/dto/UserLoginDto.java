package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserLoginDto {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
