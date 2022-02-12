package by.sam_solutions.grigorieva.olga.backend.repository.supply.product;

import by.sam_solutions.grigorieva.olga.backend.entity.SupplyProduct;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

public interface SupplyProductRepository extends AbstractRepository<SupplyProduct> {

    SupplyProduct getByProduct(String name);
}
