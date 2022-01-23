package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.country.CountryName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CountryDto {

    @NotEmpty
    private Integer id;

    @NotEmpty
    private CountryName countryName;
}
