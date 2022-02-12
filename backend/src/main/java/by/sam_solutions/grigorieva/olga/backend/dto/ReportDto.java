package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.domain.validation.CustomPattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Validated
public class ReportDto {

    @Null
    private Integer id;

    @NotNull
    private SupplyTableRowDto supply;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Long orderNumber;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private String name;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Double orderPrice;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Double proceeds;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Double logistics;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Double costPrice;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Double commission;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Double profit;

    @CustomPattern(patternKey = "field.digits.regexp", message = "field.digits.invalid")
    @NotNull
    private Double commissionPerCent;

    @NotNull
    private String dateSale;

    @NotNull
    private String dateOrder;
}
