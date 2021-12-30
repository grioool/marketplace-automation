package by.sam_solutions.grigorieva.olga.backend.service;

import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractServiceImpl<Entity> implements AbstractService<Entity> {

    private AbstractRepository<Entity> abstractRepository;

    @Transactional
    public Entity add(Entity entity) {
        abstractRepository.add(entity);
        return entity;
    }

    @Transactional
    public Entity update(Entity entity) {
        abstractRepository.update(entity);
        return entity;
    }
}
