package by.sam_solutions.grigorieva.olga.backend.controller.wb;

import by.sam_solutions.grigorieva.olga.backend.dto.SaleWBDto;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.wb.SaleWBService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SaleWBController {

    private final SaleWBService salesService;

    @GetMapping("/sales")
    public ResponseEntity<List<SaleWBDto>> getSales(Principal principal) {
        return ResponseEntity.ok().body(salesService.getByWBKey((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()));
    }
}
