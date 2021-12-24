package by.sam_solutions.grigorieva.olga.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "purchase")
@Data
public class Purchase extends AbstractEntity {
    @Column(name = "date")
    private Timestamp date;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price_for_one")
    private Double priceForOne;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "purchase")
    private Integer purchase;

    @Column(name = "logistics")
    private Double logistics;

    @Column(name = "cost_price")
    private Double costPrice;

    @Column(name = "batch_price")
    private Double batchPrice;

    @Column(name = "extra")
    private Double extra;
}
