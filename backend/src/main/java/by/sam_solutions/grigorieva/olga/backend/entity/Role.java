package by.sam_solutions.grigorieva.olga.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role extends AbstractEntity {

    @Column(name = "role_name")
    @Enumerated(value = EnumType.STRING)
    private Name roleName;

    public enum Name {
        USER, ADMIN, UNAUTHORIZED
    }
}