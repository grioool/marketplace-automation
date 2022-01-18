package by.sam_solutions.grigorieva.olga.backend.service.user;

import by.sam_solutions.grigorieva.olga.backend.entity.TokenAuthentication;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.entity.Role;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractService;

public interface UserService extends AbstractService<User> {

    User register(User user);

    User getByUsername(String username);

    TokenAuthentication authenticate(String username, String password);

    Role createRole(Role role);

    void addRoleToUser(String username, String roleName);

    User createUser(User user);

    User loadUserByUsername(String username);

    User getByEmail(String email);

}
