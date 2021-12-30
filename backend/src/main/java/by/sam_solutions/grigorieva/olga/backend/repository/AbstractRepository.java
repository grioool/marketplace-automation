package by.sam_solutions.grigorieva.olga.backend.repository;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractRepository<Entity>{

    @PersistenceContext
    private EntityManager entityManger;

    @Transactional
    public Entity add(Entity entity) {
        entityManger.persist(entity);
        return entity;
    }

    @Transactional
    public Entity update(Entity entity) {
        entityManger.merge(entity);
        return entity;
    }

    @Transactional
    public Entity delete(Entity entity) {
        if (entityManger.contains(entity)) {
            entityManger.remove(entity);
        } else {
            entityManger.remove(entityManger.merge(entity));
        }

        return entity;
    }

}
