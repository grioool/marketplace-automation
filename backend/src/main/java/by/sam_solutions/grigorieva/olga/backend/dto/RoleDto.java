package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RoleDto {

    @NotEmpty
    private int id;

    @NotEmpty
    private String roleName;
}
