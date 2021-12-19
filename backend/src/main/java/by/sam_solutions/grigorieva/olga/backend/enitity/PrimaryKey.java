package by.sam_solutions.grigorieva.olga.backend.enitity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class PrimaryKey implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
}
