package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.Report;
import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
public class ReportDto {

    public static Report toEntity(ReportDto dto) {
        Report report = new Report();
        report.setId(dto.getId());
        report.setSupply(dto.getSupply());
        report.setName(dto.getName());
        report.setCommission(dto.getCommission());
        report.setCommissionPerCent(dto.getCommissionPerCent());
        report.setCommissionVAT(dto.getCommissionVAT());
        report.setCostPrice(dto.getCostPrice());
        report.setDateOrder(dto.getDateOrder());
        report.setDateSale(dto.getDateSale());
        report.setLogistics(dto.getLogistics());
        report.setOrderNumber(dto.getOrderNumber());
        report.setOrderPrice(dto.getOrderPrice());
        report.setProceeds(dto.getProceeds());
        report.setProfit(dto.getProfit());
        return report;
    }

    public static ReportDto toDto(Report report) {
        ReportDto reportDto = new ReportDto();
        reportDto.setId(report.getId());
        reportDto.setSupply(report.getSupply());
        reportDto.setName(report.getName());
        reportDto.setCommission(report.getCommission());
        reportDto.setCommissionPerCent(report.getCommissionPerCent());
        reportDto.setCommissionVAT(report.getCommissionVAT());
        reportDto.setCostPrice(report.getCostPrice());
        reportDto.setDateOrder(report.getDateOrder());
        reportDto.setDateSale(report.getDateSale());
        reportDto.setLogistics(report.getLogistics());
        reportDto.setOrderNumber(report.getOrderNumber());
        reportDto.setOrderPrice(report.getOrderPrice());
        reportDto.setProceeds(report.getProceeds());
        reportDto.setProfit(report.getProfit());
        return reportDto;
    }

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
