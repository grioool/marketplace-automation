package by.sam_solutions.grigorieva.olga.backend.entity.country;

import by.sam_solutions.grigorieva.olga.backend.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country extends AbstractEntity {

    @Column(name = "country_name")
    @Enumerated(value = EnumType.STRING)
    private CountryName countryName;
}
