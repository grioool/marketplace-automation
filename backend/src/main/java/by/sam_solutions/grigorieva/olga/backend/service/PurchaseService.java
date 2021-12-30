package by.sam_solutions.grigorieva.olga.backend.service;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;

import java.util.List;

public interface PurchaseService extends AbstractService<Purchase> {

    List<Purchase> getAll();

    Purchase getById(int id);

    void delete(int id);
}
