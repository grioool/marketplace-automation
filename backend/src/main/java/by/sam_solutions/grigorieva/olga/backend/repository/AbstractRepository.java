package by.sam_solutions.grigorieva.olga.backend.repository;

import java.util.List;

public abstract class AbstractRepository<Entity>{

    public Entity add(Entity entity) {
        return entity;
    }

    public void delete(Entity entity) {}

    public Entity getByName(String name) {
        return null;
    }

    public Entity update(Entity entity) {
        return entity;
    }

    public List<Entity> getAll() {
        return null;
    }

}
