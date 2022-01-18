package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.town.Town;
import by.sam_solutions.grigorieva.olga.backend.entity.town.TownName;
import lombok.Data;

@Data
public class TownDto {

    public static Town toEntity(TownDto dto) {
        Town town = new Town();
        town.setId(dto.getId());
        town.setTownName(dto.getTownName());
        return town;
    }

    public static TownDto toDto(Town town) {
        TownDto dto = new TownDto();
        dto.setId(town.getId());
        dto.setTownName(town.getTownName());
        return dto;
    }

    private Integer id;

    private TownName townName;
}
