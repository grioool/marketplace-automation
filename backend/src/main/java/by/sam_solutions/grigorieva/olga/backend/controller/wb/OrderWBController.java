package by.sam_solutions.grigorieva.olga.backend.controller.wb;

import by.sam_solutions.grigorieva.olga.backend.dto.OrderWBDto;
import by.sam_solutions.grigorieva.olga.backend.service.wb.OrderWBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderWBController {

    private final OrderWBService orderWBService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderWBDto>> getSales() {
        return ResponseEntity.ok().body(orderWBService.getOrders());
    }
}
