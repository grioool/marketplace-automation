package by.sam_solutions.grigorieva.olga.backend.repository.supply;

import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;

import java.util.List;

public interface SupplyRepository extends AbstractRepository<Supply> {

    List<Supply> getByUser(User user);

    Supply getByProduct(String name);
}
