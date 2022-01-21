package by.sam_solutions.grigorieva.olga.backend.controller.wb;

import by.sam_solutions.grigorieva.olga.backend.dto.OrderWBDto;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.wb.OrderWBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderWBController {

    private final OrderWBService orderWBService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderWBDto>> getOrders(Principal principal) {
        return ResponseEntity.ok().body(orderWBService.getByWBKey((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()));
    }
}
