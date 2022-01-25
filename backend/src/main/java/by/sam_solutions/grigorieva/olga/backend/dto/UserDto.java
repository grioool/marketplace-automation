package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
public class UserDto {

    @NotNull
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
