package by.sam_solutions.grigorieva.olga.backend.service;

import by.sam_solutions.grigorieva.olga.backend.entity.User;

import java.util.List;

public interface UserService extends AbstractService<User> {

    List<User> getAll();

    User findById(int id);

    void delete(int id);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
