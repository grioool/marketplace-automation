package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.dto.ReportDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Report;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @RequestMapping(value = "/reports",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public List<ReportDto> getReports(Principal principal) {
        return reportService.getByUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).stream()
                .map(ReportDto::toDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/report/{reportId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ReportDto getReport(@PathVariable("reportId") int id) {
        return ReportDto.toDto(reportService.getById(id));
    }

    @RequestMapping(value = "/report",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ReportDto create(@RequestBody ReportDto dto, Principal principal) {
        Report report = ReportDto.toEntity(dto);
        report.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return ReportDto.toDto(reportService.create(report));
    }

    @RequestMapping(value = "/report",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ReportDto update(@RequestBody ReportDto dto, Principal principal) {
        Report report = ReportDto.toEntity(dto);
        report.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return ReportDto.toDto(reportService.update(report));
    }

    @RequestMapping(value = "/report/{reportId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void delete(@PathVariable("reportId") int id) {
        reportService.delete(id);
    }

}
