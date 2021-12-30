package by.sam_solutions.grigorieva.olga.backend.repository;

public interface AbstractRepository<Entity> {

    Entity add(Entity entity);

    Entity update(Entity entity);
}
