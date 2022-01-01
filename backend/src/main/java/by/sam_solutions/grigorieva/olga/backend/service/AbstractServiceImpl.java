package by.sam_solutions.grigorieva.olga.backend.service;

import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractServiceImpl<Entity> implements AbstractService<Entity> {

    private final AbstractRepository<Entity> abstractRepository;

    @Transactional
    public Entity create(Entity entity) {
        return abstractRepository.create(entity);
    }

    @Transactional
    public Entity update(Entity entity) {
        return abstractRepository.update(entity);
    }

    @Transactional
    public List<Entity> getAll() {
        return abstractRepository.getAll();
    }

    @Transactional
    public Entity getById(int id) {
        return abstractRepository.getById(id);
    }

    @Transactional
    public void delete(int id) {
        abstractRepository.delete(id);
    }
}
