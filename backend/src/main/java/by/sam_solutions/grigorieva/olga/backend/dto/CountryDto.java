package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.country.CountryName;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
public class CountryDto {

    @NotNull
    private Integer id;

    @NotNull
    private CountryName countryName;
}
