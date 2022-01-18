package by.sam_solutions.grigorieva.olga.backend.repository.town;

import by.sam_solutions.grigorieva.olga.backend.entity.town.Town;
import by.sam_solutions.grigorieva.olga.backend.entity.town.TownName;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;

public interface TownRepository extends AbstractRepository<Town> {

    Town findByName(TownName name);

}
