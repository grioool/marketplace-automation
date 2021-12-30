package by.sam_solutions.grigorieva.olga.backend.repository;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;

import java.util.List;

public interface PurchaseRepository extends AbstractRepository<Purchase> {

    List<Purchase> getAll();

    Purchase getById(int id);

    void delete(int id);
}
