package by.sam_solutions.grigorieva.olga.backend.repository;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PurchaseRepository extends AbstractRepository<Purchase> {

    @PersistenceContext
    private EntityManager entityManger;

    @Transactional
    public void delete(int id) {
        entityManger.remove(getById(id));
    }

    @Transactional
    public Purchase getById(Integer id) {
        return entityManger.find(Purchase.class, id);
    }

    public List<Purchase> getAll() {
        CriteriaBuilder cb = entityManger.getCriteriaBuilder();
        CriteriaQuery<Purchase> cq = cb.createQuery(Purchase.class);
        Root<Purchase> rootEntry = cq.from(Purchase.class);
        CriteriaQuery<Purchase> all = cq.select(rootEntry);
        TypedQuery<Purchase> allQuery = entityManger.createQuery(all);
        return allQuery.getResultList();
    }
}