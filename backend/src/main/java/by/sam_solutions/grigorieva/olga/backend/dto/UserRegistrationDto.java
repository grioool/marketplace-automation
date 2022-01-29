package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Validated
public class UserRegistrationDto {

    @NotNull
    @Pattern(regexp="^[(\\w)-]{3,20}")
    private String username;

    @NotNull
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,10}")
    private String password;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp="^[A-Za-zА-Яа-яЁё]{2,20}")
    private String nameCompany;

    @NotNull
    @Pattern(regexp="^[A-Za-zА-Яа-яЁё0-9]{2,20}")
    private String wbKey;

}
