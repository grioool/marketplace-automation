package by.sam_solutions.grigorieva.olga.backend.enitity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "role")
@Data
public class Role extends PrimaryKey {

    @Column(name = "role_name")
    private String roleName;
}
