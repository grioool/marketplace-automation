package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.entity.Report;
import by.sam_solutions.grigorieva.olga.backend.service.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @RequestMapping(value = "/reports",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Report> getReports() {
        return reportService.getAll();
    }

    @RequestMapping(value = "/reports/{reportId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Report getReport(@PathVariable("reportId") int id) {
        return reportService.getById(id);
    }

    @RequestMapping(value = "/report",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Report create(@RequestBody Report report) {
        return reportService.create(report);
    }

    @RequestMapping(value = "/report",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Report update(@RequestBody Report report) {
        return reportService.update(report);
    }

    @RequestMapping(value = "/report/{reportId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void delete(@PathVariable("reportId") int id) {
        reportService.delete(id);
    }

}
