package by.sam_solutions.grigorieva.olga.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "supply")
@Getter
@Setter
public class Supply extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "product")
    private String product;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "logistics")
    private Double logistics;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "fulfillment")
    private Double fulfilment;

    @Column(name = "cost_price")
    private Double costPrice;

}
