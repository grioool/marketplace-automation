package by.sam_solutions.grigorieva.olga.backend.repository.user;

import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends AbstractRepositoryImpl<User> implements UserRepository{

    public User findByUsername(String username) {
        return entityManager.createQuery(
                        "SELECT u from User u WHERE u.username = :username", User.class
                )
                .setParameter("username", username)
                .getSingleResult();
    }

    public User findByEmail(String email) {
        return entityManager.createQuery(
                        "SELECT u from User u WHERE u.email = :email", User.class
                )
                .setParameter("email", email)
                .getSingleResult();
    }
}
