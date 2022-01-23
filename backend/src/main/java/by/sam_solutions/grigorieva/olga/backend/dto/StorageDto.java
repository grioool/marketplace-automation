package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class StorageDto {

    @NotEmpty
    private Integer id;

    @NotEmpty
    private CountryDto country;

    @NotEmpty
    private TownDto town;

}
