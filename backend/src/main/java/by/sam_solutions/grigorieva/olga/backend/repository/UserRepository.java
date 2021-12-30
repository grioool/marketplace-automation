package by.sam_solutions.grigorieva.olga.backend.repository;

import by.sam_solutions.grigorieva.olga.backend.entity.User;
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
public class UserRepository extends AbstractRepository<User>{

    @PersistenceContext
    private EntityManager entityManger;

    @Transactional
    public void delete(int id) {
        entityManger.remove(getById(id));
    }

    @Transactional
    public User getById(Integer id) {
        return entityManger.find(User.class, id);
    }

    public List<User> getAll() {
        CriteriaBuilder cb = entityManger.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = entityManger.createQuery(all);
        return allQuery.getResultList();
    }
}
