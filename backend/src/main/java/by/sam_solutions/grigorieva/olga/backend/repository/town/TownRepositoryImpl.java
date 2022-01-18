package by.sam_solutions.grigorieva.olga.backend.repository.town;

import by.sam_solutions.grigorieva.olga.backend.entity.town.Town;
import by.sam_solutions.grigorieva.olga.backend.entity.town.TownName;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class TownRepositoryImpl extends AbstractRepositoryImpl<Town> implements TownRepository {

    public Town findByName(TownName name) {
        return entityManager.createQuery(
                        "SELECT t from Town t WHERE t.townName = :townName", Town.class
                )
                .setParameter("townName", name)
                .getSingleResult();
    }

}
