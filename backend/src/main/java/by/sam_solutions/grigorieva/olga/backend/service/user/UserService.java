package by.sam_solutions.grigorieva.olga.backend.service.user;

import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractService;

public interface UserService extends AbstractService<User> {

    User register(User user);

    User getByUsername(String username);

    String authenticate(String username, String password);
}
