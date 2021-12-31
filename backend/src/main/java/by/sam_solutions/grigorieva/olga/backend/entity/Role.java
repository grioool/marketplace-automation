package by.sam_solutions.grigorieva.olga.backend.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Getter
@Table(name = "role")
public enum Role {

    USER(1), ADMIN(2), UNAUTHORIZED(3);

    @Column(name = "role_name")
    private String roleName;

    @Id
    private Integer id;

    Role(Integer id) {
        this.id = id;
    }

    Role() {
    }
}
