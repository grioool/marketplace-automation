package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.town.TownName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TownDto {

    @NotEmpty
    private Integer id;

    @NotEmpty
    private TownName townName;
}
