package by.sam_solutions.grigorieva.olga.backend.controller.wb;

import by.sam_solutions.grigorieva.olga.backend.dto.SaleWBDto;
import by.sam_solutions.grigorieva.olga.backend.service.wb.SaleWBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SaleWBController {

    private final SaleWBService salesService;

    @GetMapping("/sales")
    public ResponseEntity<List<SaleWBDto>> getSales() {
        return ResponseEntity.ok().body(salesService.getSales());
    }
}
