package by.sam_solutions.grigorieva.olga.backend.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "role")
public enum Role {

    USER, ADMIN, UNAUTHORIZED;

    @Column(name = "role_name")
    private String roleName;

    @Id
    private Integer id;

}
