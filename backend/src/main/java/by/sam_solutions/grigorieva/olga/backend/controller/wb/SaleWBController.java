package by.sam_solutions.grigorieva.olga.backend.controller.wb;

import by.sam_solutions.grigorieva.olga.backend.domain.table.TablePage;
import by.sam_solutions.grigorieva.olga.backend.dto.wb.SaleWBDto;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.wb.SaleWBService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SaleWBController {

    private final SaleWBService salesService;
    private final Logger logger = LoggerFactory.getLogger(SaleWBController.class);

    @GetMapping("/sales")
    public ResponseEntity<List<SaleWBDto>> getSales(Principal principal) {
        logger.info("Getting sales...");
        return ResponseEntity.ok().body(salesService.getByDateFrom(mockDate(), getUser(principal)));
    }

    @GetMapping("/salesbypage")
    public TablePage<SaleWBDto> getSalesByPage(@RequestParam Integer shift,
                                               @RequestParam Integer rowsPerPage,
                                               Principal principal) {
        logger.info("Getting sales by page...");
        return salesService.getByShift(shift, rowsPerPage, mockDate(), getUser(principal));
    }

    private User getUser(Principal principal) {
        return (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
    }

    private Date mockDate() {
        return Date.from(Instant.now().minus(1, ChronoUnit.WEEKS));
    }
}
