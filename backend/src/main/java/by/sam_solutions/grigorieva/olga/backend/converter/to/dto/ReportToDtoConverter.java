package by.sam_solutions.grigorieva.olga.backend.converter.to.dto;

import by.sam_solutions.grigorieva.olga.backend.dto.ReportDto;
import by.sam_solutions.grigorieva.olga.backend.dto.SupplyDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Report;
import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
public class ReportToDtoConverter implements Converter<Report, ReportDto> {

    private final ConversionService conversionService;

    @Override
    public ReportDto convert(Report report) {
        ReportDto reportDto = new ReportDto();
        reportDto.setId(report.getId());
        reportDto.setSupply(conversionService.convert(report.getSupply(), Supply.class));
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
}
