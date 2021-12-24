package by.sam_solutions.grigorieva.olga.backend.service;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;

import java.util.List;

public interface PurchaseService {

    Purchase add(Purchase purchase);

    Purchase delete(Purchase purchase);

    Purchase getByName(String name);

    Purchase getById(Integer id);

    Purchase update(Purchase purchase);

    List<Purchase> getAll();
}
