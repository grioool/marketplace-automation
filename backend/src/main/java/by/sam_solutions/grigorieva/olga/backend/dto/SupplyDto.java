package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
public class SupplyDto {

    private Integer id;

    @NotEmpty
    private PurchaseDto purchase;

    @NotEmpty
    private StorageDto storage;

    @NotEmpty
    private Timestamp date;

    @Pattern(regexp="^[A-Za-zА-Яа-яЁё]{2,15}")
    @NotEmpty
    private String product;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Integer amount;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double logistics;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double purchasePrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double fulfillment;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double costPrice;
}
