package by.sam_solutions.grigorieva.olga.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "supply")
@Data
public class Supply extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_id", nullable = false)
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "storage_id", nullable = false)
    private Storage storage;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "product", nullable = false)
    private String product;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "logistics", nullable = false)
    private Double logistics;

    @Column(name = "purchase_price", nullable = false)
    private Double purchasePrice;

    @Column(name = "fulfillment", nullable = false)
    private Double fulfillment;

    @Column(name = "cost_price", nullable = false)
    private Double costPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
