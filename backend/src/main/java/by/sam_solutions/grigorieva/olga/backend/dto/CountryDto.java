package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.country.Country;
import by.sam_solutions.grigorieva.olga.backend.entity.country.CountryName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CountryDto {

    public static Country toEntity(CountryDto dto) {
        Country country = new Country();
        country.setId(dto.getId());
        country.setCountryName(dto.getCountryName());
        return country;
    }

    public static CountryDto toDto(Country country) {
        CountryDto dto = new CountryDto();
        dto.setId(country.getId());
        dto.setCountryName(country.getCountryName());
        return dto;
    }

    @NotEmpty
    private Integer id;

    @NotEmpty
    private CountryName countryName;
}
