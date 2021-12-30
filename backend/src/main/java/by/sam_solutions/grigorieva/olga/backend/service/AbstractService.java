package by.sam_solutions.grigorieva.olga.backend.service;

public interface AbstractService<Entity> {

    Entity add(Entity entity);

    Entity update(Entity entity);
}
