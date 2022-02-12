package by.sam_solutions.grigorieva.olga.backend.repository.supply;

import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepositoryImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class SupplyRepositoryImpl extends AbstractRepositoryImpl<Supply> implements SupplyRepository {

    @Override
    public List<Supply> getByUser(User user) {
        return entityManager.createQuery("SELECT s FROM Supply s WHERE s.user = :user")
                .setParameter("user", user)
                .getResultList();
    }

    @Override
    public Supply getByProduct(String product) {
        try {
            return entityManager.createQuery(
                            "SELECT s from Supply s WHERE s.product = :product", Supply.class
                    )
                    .setParameter("product", product)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Supply getByIdAndProductName(String product, int id) {
        try {
            return entityManager.createQuery(
                            "SELECT s from Supply s, SupplyProduct sp " +
                                    "WHERE s.id = :id AND s = sp.supply AND sp.product = :product", Supply.class
                    )
                    .setParameter("id", id)
                    .setParameter("product", product)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
