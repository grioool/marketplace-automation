package by.sam_solutions.grigorieva.olga.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "supply_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplyProduct extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supply_id", nullable = false)
    private Supply supply;

    @Column(name = "product", nullable = false)
    private String product;

    @Column(name = "amount", nullable = false)
    private Integer amount;

}
