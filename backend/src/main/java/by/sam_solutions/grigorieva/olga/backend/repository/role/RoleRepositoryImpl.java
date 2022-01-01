package by.sam_solutions.grigorieva.olga.backend.repository.role;

import by.sam_solutions.grigorieva.olga.backend.entity.Role;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepositoryImpl;

public class RoleRepositoryImpl extends AbstractRepositoryImpl<Role> implements RoleRepository {

    public Role findByName(Role.Name name) {
        return entityManager.createQuery(
                        "SELECT r from Role r WHERE r.roleName = :roleName", Role.class
                )
                .setParameter("roleName", name)
                .getSingleResult();
    }
}
