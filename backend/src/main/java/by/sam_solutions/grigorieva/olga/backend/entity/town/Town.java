package by.sam_solutions.grigorieva.olga.backend.entity.town;

import by.sam_solutions.grigorieva.olga.backend.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "town")
@Getter
@Setter
public class Town extends AbstractEntity {

    @Column(name = "town_name")
    @Enumerated(value = EnumType.STRING)
    private TownName townName;

}
