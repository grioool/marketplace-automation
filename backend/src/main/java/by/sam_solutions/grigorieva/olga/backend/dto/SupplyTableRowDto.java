package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.domain.validation.CustomPattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Validated
public class SupplyTableRowDto {

    @NotNull
    private Integer id;

    @NotNull
    private PurchaseDto purchase;

    @NotNull
    private StorageDto storage;

    @NotNull
    private Timestamp date;

    @CustomPattern(patternKey = "field.letters.regexp", message = "field.letters.invalid")
    @NotNull
    private String product;

    private Integer amount;

    @NotNull
    private Double logistics;

    @NotNull
    private Double purchasePrice;

    @NotNull
    private Double fulfillment;

    @NotNull
    private Double costPrice;

    public static SupplyTableRowDto blank(Integer id) {
        SupplyTableRowDto supplyTableRowDto = new SupplyTableRowDto();
        supplyTableRowDto.setId(id);
        supplyTableRowDto.setCostPrice(-1.0);
        return supplyTableRowDto;
    }
}
