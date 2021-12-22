package by.sam_solutions.grigorieva.olga.backend.dao;

import by.sam_solutions.grigorieva.olga.backend.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDao extends AbstractDao<User>{

    @PersistenceContext
    private EntityManager entityManager;
}
