package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
public class ReportDto {

    private Integer id;

    @NotEmpty
    private Supply supply;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Integer orderNumber;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private String name;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double orderPrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double proceeds;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double logistics;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double costPrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double commission;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double profit;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double commissionPerCent;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double commissionVAT;

    @NotEmpty
    private Timestamp dateSale;

    @NotEmpty
    private Timestamp dateOrder;
}
