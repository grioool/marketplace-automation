package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.dto.PurchaseDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.purchase.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping(value = "/purchases")
    public List<PurchaseDto> getPurchases(Principal principal) {
        return purchaseService.getByUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).stream()
                .map(PurchaseDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/purchase/{purchaseId}")
    public PurchaseDto getPurchase(@PathVariable("purchaseId") int id) {
        return PurchaseDto.toDto(purchaseService.getById(id));
    }

    @PostMapping(value = "/purchase")
    public PurchaseDto create(@RequestBody PurchaseDto dto, Principal principal) {
        Purchase purchase = PurchaseDto.toEntity(dto);
        purchase.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return PurchaseDto.toDto(purchaseService.create(purchase));
    }

    @PutMapping(value = "/purchase")
    public PurchaseDto update(@RequestBody PurchaseDto dto, Principal principal) {
        Purchase purchase = PurchaseDto.toEntity(dto);
        purchase.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return PurchaseDto.toDto(purchaseService.update(purchase));
    }

    @DeleteMapping(value = "/purchase/{purchaseId}")

    public void delete(@PathVariable("purchaseId") int id) {
       purchaseService.delete(id);
    }
}