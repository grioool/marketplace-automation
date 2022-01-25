package by.sam_solutions.grigorieva.olga.backend.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
@Validated
public class PurchaseDto {

    private Integer id;

    @NotNull
    private Timestamp date;

    @Pattern(regexp="^[A-Za-zА-Яа-яЁё]{2,15}")
    @NotNull
    private String productName;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double priceForOne;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Integer amount;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Integer purchasePrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double logistics;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double costPrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double batchPrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double extra;
}
