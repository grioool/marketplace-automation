package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.domain.validation.CustomPattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
    private String date;

    @NotNull
    private String product;

    @NotNull
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
