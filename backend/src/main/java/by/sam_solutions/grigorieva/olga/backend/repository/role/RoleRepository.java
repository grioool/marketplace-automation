package by.sam_solutions.grigorieva.olga.backend.repository.role;

import by.sam_solutions.grigorieva.olga.backend.entity.role.Role;
import by.sam_solutions.grigorieva.olga.backend.entity.role.RoleName;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;

public interface RoleRepository extends AbstractRepository<Role> {

    Role findByName(RoleName name);
}
