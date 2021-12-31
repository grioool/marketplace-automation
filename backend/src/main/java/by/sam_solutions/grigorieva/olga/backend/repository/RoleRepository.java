package by.sam_solutions.grigorieva.olga.backend.repository;

import by.sam_solutions.grigorieva.olga.backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public interface RoleRepository {

    static Role findById(Integer id) {
        return Arrays.stream(Role.values())
                .filter(role -> role.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    static Role findByName(String name) {
        return Arrays.stream(Role.values())
                .filter(role -> role.getRoleName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
