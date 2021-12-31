package by.sam_solutions.grigorieva.olga.backend.repository;

import by.sam_solutions.grigorieva.olga.backend.entity.User;

import java.util.List;

public interface UserRepository extends AbstractRepository<User> {

    List<User> getAll();

    User findById(int id);

    void delete(int id);

    User findByUsername(String username);
}
