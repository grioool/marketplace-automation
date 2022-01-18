package by.sam_solutions.grigorieva.olga.backend.entity;

import by.sam_solutions.grigorieva.olga.backend.entity.AbstractEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractEntity implements GrantedAuthority {

    @Column(name = "role_name")
    private String roleName;

    public String getAuthority() {
        return roleName;
    }
}