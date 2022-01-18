package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UserRegistrationDto {

    @NotEmpty
    @Pattern(regexp="^[(\\w)-]{3,20}")
    private String username;

    @NotEmpty
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,10}")
    private String password;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Pattern(regexp="^[A-Za-zА-Яа-яЁё]{2,20}")
    private String nameCompany;

    @NotEmpty
    @Pattern(regexp="^[0-9]{2,20}")
    private String wbKey;

    @NotEmpty
    @Pattern(regexp="^[0-9]{2,20}")
    private String ozonKey;

}
