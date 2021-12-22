package by.sam_solutions.grigorieva.olga.backend.service;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;

import java.util.List;

public interface PurchaseService {

    Purchase addPurchase(Purchase purchase);

    void delete(Purchase purchase);

    Purchase getByName(String name);

    Purchase updatePurchase(Purchase purchase);

    List<Purchase> getAll();
}
