package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
public class UserLoginDto {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
