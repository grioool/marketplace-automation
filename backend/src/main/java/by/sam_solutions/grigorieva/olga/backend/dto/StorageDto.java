package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.Storage;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class StorageDto {

    public static Storage toEntity(StorageDto dto) {
        Storage storage = new Storage();
        storage.setId(dto.getId());
        storage.setCountry(CountryDto.toEntity(dto.getCountry()));
        storage.setTown(TownDto.toEntity(dto.getTown()));
        return storage;
    }

    public static StorageDto toDto(Storage storage) {
        StorageDto dto = new StorageDto();
        dto.setId(storage.getId());
        dto.setCountry(CountryDto.toDto(storage.getCountry()));
        dto.setTown(TownDto.toDto(storage.getTown()));
        return dto;
    }

    @NotEmpty
    private Integer id;

    @NotEmpty
    private CountryDto country;

    @NotEmpty
    private TownDto town;

}
