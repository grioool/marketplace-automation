package by.sam_solutions.grigorieva.olga.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "report")
@Getter
@Setter
public class Report extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supply_id")
    private Supply supply;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "order_price")
    private Double orderPrice;

    @Column(name = "proceeds")
    private Double proceeds;

    @Column(name = "logistics")
    private Double logistics;

    @Column(name = "cost_price")
    private Double costPrice;

    @Column(name = "commission")
    private Double commission;

    @Column(name = "profit")
    private Double profit;

    @Column(name = "commission_per_cent")
    private Double commissionPerCent;

    @Column(name = "commission_vat")
    private Double commissionVAT;

    @Column(name = "date_sale")
    private Timestamp dateSale;

    @Column(name = "date_order")
    private Timestamp dateOrder;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
