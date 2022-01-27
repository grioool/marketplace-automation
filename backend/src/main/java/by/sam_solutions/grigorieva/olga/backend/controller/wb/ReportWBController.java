package by.sam_solutions.grigorieva.olga.backend.controller.wb;

import by.sam_solutions.grigorieva.olga.backend.domain.table.TablePage;
import by.sam_solutions.grigorieva.olga.backend.dto.ReportWBDto;
import by.sam_solutions.grigorieva.olga.backend.dto.SaleWBDto;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.wb.ReportsWBService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReportWBController {
    private final ReportsWBService reportsService;
    private final Logger logger = LoggerFactory.getLogger(SaleWBController.class);

    @GetMapping("/reportsWB")
    public ResponseEntity<List<ReportWBDto>> getReportsWB(Principal principal) {
        logger.info("Getting reports...");
        return ResponseEntity.ok().body(reportsService.getByWBKey(getUser(principal)));
    }

    @GetMapping("/reportsWBbypage")
    public TablePage<ReportWBDto> getReportsWBByPage(@RequestParam Integer shift,
                                               @RequestParam Integer rowsPerPage,
                                               Principal principal) {
        logger.info("Getting reports by page...");
        return reportsService.getByShift(getUser(principal), shift, rowsPerPage);
    }

    private User getUser(Principal principal) {
        return (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
    }
}
