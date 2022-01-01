package by.sam_solutions.grigorieva.olga.backend.service;

import by.sam_solutions.grigorieva.olga.backend.entity.User;

import java.util.List;

public interface AbstractService<Entity> {

    Entity create(Entity entity);

    Entity update(Entity entity);

    List<Entity> getAll();

    Entity getById(int id);

    void delete(int id);

}
