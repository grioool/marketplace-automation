package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {

    @NotEmpty
    private int id;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String username;

    @NotEmpty
    private String nameCompany;

    @NotEmpty
    private String wildBerriesKeys;

    @NotEmpty
    private Boolean isBlocked;

    @NotEmpty
    private Boolean isSubscribed;
}
