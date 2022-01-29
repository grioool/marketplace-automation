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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class ReportController {

    private final ReportService reportService;
    private final Logger logger = LoggerFactory.getLogger(ReportController.class);
    private final ConversionService conversionService;

    @GetMapping(value = "/reports")
    public ResponseEntity<List<ReportDto>> getReports(Principal principal) {
        logger.info("Getting reports...");
        return new ResponseEntity<>(reportService.getByUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).stream()
                .map(report -> conversionService.convert(report, ReportDto.class))
                .collect(Collectors.toList()), HttpStatus.OK);
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
    public ResponseEntity<ReportDto> getReport(@PathVariable("reportId") int id) {
        logger.info("Getting report...");
        return new ResponseEntity<>(conversionService.convert(reportService.getById(id), ReportDto.class), HttpStatus.OK);
    }

    @PostMapping(value = "/report")
    public ResponseEntity<ReportDto> create(@RequestBody @Valid ReportDto reportDto, Principal principal) {
        logger.info("Creating report...");
        Report report = conversionService.convert(reportDto, Report.class);
        report.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return new ResponseEntity<>(conversionService.convert(reportService.create(report), ReportDto.class), HttpStatus.OK);
    }

    @PutMapping(value = "/report")
    public ResponseEntity<ReportDto> update(@RequestBody ReportDto reportDto, Principal principal) {
        logger.info("Updating report...");
        Report report = conversionService.convert(reportDto, Report.class);
        report.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return new ResponseEntity<>(conversionService.convert(reportService.update(report), ReportDto.class), HttpStatus.OK);
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
