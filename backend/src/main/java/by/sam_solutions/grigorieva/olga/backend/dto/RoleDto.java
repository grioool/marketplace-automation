package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.domain.validation.CustomPattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Validated
public class RoleDto {

    @Null
    private int id;

    @NotNull
    @CustomPattern(patternKey = "field.letters.regexp", message = "field.letters.invalid")
    private String roleName;
}
