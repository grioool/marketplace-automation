package by.sam_solutions.grigorieva.olga.backend.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import by.sam_solutions.grigorieva.olga.backend.dto.PurchaseDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.exception.ServiceException;
import by.sam_solutions.grigorieva.olga.backend.service.purchase.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/purchase/{purchaseId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PurchaseDto getPurchase(@PathVariable("purchaseId") int id) {
        return PurchaseDto.toDto(purchaseService.getById(id));
    }

    @RequestMapping(value = "/purchase",
            method = RequestMethod.POST)
    public PurchaseDto create(@RequestBody PurchaseDto dto, Principal principal) {
        Purchase purchase = PurchaseDto.toEntity(dto);
        purchase.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return PurchaseDto.toDto(purchaseService.create(purchase));
    }

    @RequestMapping(value = "/purchase",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PurchaseDto update(@RequestBody PurchaseDto dto, Principal principal) {
        Purchase purchase = PurchaseDto.toEntity(dto);
        purchase.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return PurchaseDto.toDto(purchaseService.update(purchase));
    }

    @RequestMapping(value = "/purchase/{purchaseId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void delete(@PathVariable("purchaseId") int id) {
       purchaseService.delete(id);
    }

}