package by.sam_solutions.grigorieva.olga.backend.service;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService {

    @PersistenceContext
    private EntityManager entityManger;

    @Transactional
    public Purchase add(Purchase purchase) {
        entityManger.persist(purchase);
        return purchase;
    }

    @Transactional
    public Purchase update(Purchase purchase) {
        entityManger.merge(purchase);
        return purchase;
    }

    @Transactional
    public Purchase delete(Purchase purchase) {
        if (entityManger.contains(purchase)) {
            entityManger.remove(purchase);
        } else {
            entityManger.remove(entityManger.merge(purchase));
        }

        return purchase;
    }

    @Transactional
    public Purchase getById(Integer id) {
        return entityManger.find(Purchase.class, id);
    }

    @Transactional
    public Purchase getByName(String name) {
        return entityManger.find(Purchase.class, name);
    }

    @Override
    public List<Purchase> getAll() {
        return entityManger.createQuery("SELECT a FROM Purchase a", Purchase.class).getResultList();
    }
}
