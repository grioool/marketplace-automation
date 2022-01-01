package by.sam_solutions.grigorieva.olga.backend.service.user;

import by.sam_solutions.grigorieva.olga.backend.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User update(User user);

    User register(User user);

    List<User> findAll();

    User getById(int id);

    void delete(int id);

    User getByUsername(String username);

    User getByUsernameAndPassword(String username, String password);
}
