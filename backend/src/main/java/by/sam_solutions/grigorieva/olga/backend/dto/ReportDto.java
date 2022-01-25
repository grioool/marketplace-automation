package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
@Validated
public class ReportDto {

    @NotNull
    private Integer id;

    @NotNull
    private Supply supply;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Integer orderNumber;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private String name;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double orderPrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double proceeds;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double logistics;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double costPrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double commission;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double profit;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double commissionPerCent;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotNull
    private Double commissionVAT;

    @NotNull
    private Timestamp dateSale;

    @NotNull
    private Timestamp dateOrder;
}
