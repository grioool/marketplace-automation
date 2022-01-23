package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.dto.SupplyDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.supply.SupplyService;
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
public class SupplyController {

    private final SupplyService supplyService;
    private final Logger logger = LoggerFactory.getLogger(SupplyController.class);
    private final ConversionService conversionService;

    @GetMapping(value = "/supplies")
    public List<SupplyDto> getSupplies(Principal principal) {
        logger.info("Getting supplies...");
        return supplyService.getByUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).stream()
                .map(supply -> conversionService.convert(supply, SupplyDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/supply/{supplyId}")
    public SupplyDto getSupply(@PathVariable("supplyId") int id) {
        logger.info("Getting supply...");
        return conversionService.convert(supplyService.getById(id), SupplyDto.class);
    }

    @PostMapping(value = "/supply")
    public SupplyDto create(@RequestBody SupplyDto supplyDto, Principal principal) {
        logger.info("Creating supply...");
        Supply supply = conversionService.convert(supplyDto, Supply.class);
        supply.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return conversionService.convert(supplyService.create(supply), SupplyDto.class);
    }

    @PutMapping(value = "/supply")
    public SupplyDto update(@RequestBody SupplyDto supplyDto, Principal principal) {
        logger.info("Updating supply...");
        Supply supply = conversionService.convert(supplyDto, Supply.class);
        supply.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return conversionService.convert(supplyService.update(supply), SupplyDto.class);
    }

    @DeleteMapping(value = "/supply/{supplyId}")
    public void delete(@PathVariable("supplyId") int id) {
        logger.info("Deleting supply...");
        supplyService.delete(id);
        logger.info("Deleted.");
    }

}
