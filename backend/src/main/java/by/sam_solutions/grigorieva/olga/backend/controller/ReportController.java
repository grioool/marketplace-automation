package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.domain.table.TablePage;
import by.sam_solutions.grigorieva.olga.backend.dto.ReportDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Report;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final Logger logger = LoggerFactory.getLogger(ReportController.class);
    private final ConversionService conversionService;

    @GetMapping(value = "/reports")
    public List<ReportDto> getReports(Principal principal) {
        logger.info("Getting reports...");
        return reportService.getByUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).stream()
                .map(report -> conversionService.convert(report, ReportDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/reportsbypage")
    public TablePage<ReportDto> getReportsByPage(@RequestParam Integer shift, @RequestParam Integer rowsPerPage, Principal principal) {
        logger.info("Getting reports by page...");
        TablePage<Report> page = reportService.getReportsPerPage(getUser(principal), shift, rowsPerPage);
        return new TablePage<>(
                page.getItems().stream()
                        .map(report -> conversionService.convert(report, ReportDto.class))
                        .collect(Collectors.toList()),
                page.getTotalCount()
        );
    }

    @GetMapping(value = "/report/{reportId}")
    public ReportDto getReport(@PathVariable("reportId") int id) {
        logger.info("Getting report...");
        return conversionService.convert(reportService.getById(id), ReportDto.class);
    }

    @PostMapping(value = "/report")
    public ReportDto create(@RequestBody ReportDto reportDto, Principal principal) {
        logger.info("Creating report...");
        Report report = conversionService.convert(reportDto, Report.class);
        report.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return conversionService.convert(reportService.create(report), ReportDto.class);
    }

    @PutMapping(value = "/report")
    public ReportDto update(@RequestBody ReportDto reportDto, Principal principal) {
        logger.info("Updating report...");
        Report report = conversionService.convert(reportDto, Report.class);
        report.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return conversionService.convert(reportService.update(report), ReportDto.class);
    }

    @DeleteMapping(value = "/report/{reportId}")
    public void delete(@PathVariable("reportId") int id) {
        logger.info("Deleting report...");
        reportService.delete(id);
        logger.info("Deleted.");
    }

    private User getUser(Principal principal) {
        return (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
    }

}
