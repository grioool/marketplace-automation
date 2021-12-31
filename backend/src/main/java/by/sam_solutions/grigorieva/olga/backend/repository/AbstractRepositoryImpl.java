package by.sam_solutions.grigorieva.olga.backend.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractRepositoryImpl<Entity>{

    @PersistenceContext
    private EntityManager entityManger;

    @Transactional
    public Entity create(Entity entity) {
        entityManger.persist(entity);
        return entity;
    }

    @Transactional
    public Entity update(Entity entity) {
        entityManger.merge(entity);
        return entity;
    }
}
