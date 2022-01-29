package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Validated
public class UserDto {

    @Null
    private int id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String username;

    @NotNull
    private String nameCompany;

    @NotNull
    private String wildBerriesKeys;

    @NotNull
    private Boolean isBlocked;

    @NotNull
    private Boolean isSubscribed;
}
