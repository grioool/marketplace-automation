package by.sam_solutions.grigorieva.olga.backend.repository;

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
}
