package by.sam_solutions.grigorieva.olga.backend.service.purchase;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;

import java.util.List;

public interface PurchaseService {

    Purchase create(Purchase purchase);

    Purchase update(Purchase purchase);

    List<Purchase> getAll();

    Purchase getById(int id);

    void delete(int id);
}
