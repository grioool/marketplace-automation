package by.sam_solutions.grigorieva.olga.backend.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "supply")
@Getter
@Setter
public class Supply extends AbstractEntity {

    @Column(name = "wildberries_id")
    private Integer wildberriesId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_id", nullable = false)
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "storage_id", nullable = false)
    private Storage storage;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "supply", cascade = CascadeType.ALL)
    private Set<SupplyProduct> supplyProducts = new LinkedHashSet<>();

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

    public void addSupplyProduct(SupplyProduct supplyProduct) {
        supplyProduct.setSupply(this);
        supplyProducts.add(supplyProduct);
    }
}
