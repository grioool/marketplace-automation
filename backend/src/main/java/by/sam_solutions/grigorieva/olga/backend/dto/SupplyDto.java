package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.domain.validation.CustomPattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
@Validated
public class SupplyDto {

    @Null
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

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Integer amount;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Double logistics;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Double purchasePrice;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Double fulfillment;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Double costPrice;

    public static SupplyDto blank(Integer id) {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setId(id);
        supplyDto.setCostPrice(-1.0);
        return supplyDto;
    }
}
