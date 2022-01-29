package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Validated
public class UserRegistrationDto {

    @NotNull
    @Pattern(regexp="^[A-Za-zА-Яа-яЁё]{2,20}", message="only letters allowed in username")
    private String username;

    @NotNull
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,10}", message="password must include from 6 to 20 digits, 1 big letter, 1 letter")
    private String password;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp="^[A-Za-zА-Яа-яЁё]{2,20}", message="only letters allowed in nameCompany")
    private String nameCompany;

    @NotNull
    @Pattern(regexp="^[A-Za-zА-Яа-яЁё0-9]{2,20}", message="only letters and digits allowed in wbKey")
    private String wbKey;

}
