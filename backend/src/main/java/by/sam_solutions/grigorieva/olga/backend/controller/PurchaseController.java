package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.dto.PurchaseDto;
import by.sam_solutions.grigorieva.olga.backend.dto.SupplyDto;
import by.sam_solutions.grigorieva.olga.backend.dto.UserDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.purchase.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final Logger logger = LoggerFactory.getLogger(PurchaseController.class);
    private final ConversionService conversionService;

    @GetMapping(value = "/purchases")
    public List<PurchaseDto> getPurchases(Principal principal) {
        logger.info("Getting purchases...");
        return purchaseService.getByUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).stream()
                .map(purchase -> conversionService.convert(purchase, PurchaseDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/purchase/{purchaseId}")
    public PurchaseDto getPurchase(@PathVariable("purchaseId") int id) {
        logger.info("Getting purchase...");
        return conversionService.convert(purchaseService.getById(id), PurchaseDto.class);
    }

    @PostMapping(value = "/purchase")
    public PurchaseDto create(@RequestBody PurchaseDto purchaseDto, Principal principal) {
        logger.info("Creating purchase...");
        Purchase purchase = conversionService.convert(purchaseDto, Purchase.class);
        purchase.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return conversionService.convert(purchaseService.create(purchase), PurchaseDto.class);
    }

    @PutMapping(value = "/purchase")
    public PurchaseDto update(@RequestBody PurchaseDto purchaseDto, Principal principal) {
        logger.info("Updating purchase...");
        Purchase purchase = conversionService.convert(purchaseDto, Purchase.class);
        purchase.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return conversionService.convert(purchaseService.update(purchase), PurchaseDto.class);
    }

    @DeleteMapping(value = "/purchase/{purchaseId}")
    public void delete(@PathVariable("purchaseId") int id) {
        logger.info("Deleting purchase...");
        purchaseService.delete(id);
        logger.info("Deleted.");
    }
}