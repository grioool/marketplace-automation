package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.dto.SupplyDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.supply.SupplyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping(value = "/supplies")
    public List<SupplyDto> getSupplies(Principal principal) {
        logger.info("Getting supplies...");
        return supplyService.getByUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).stream()
                .map(SupplyDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/supply/{supplyId}")
    public SupplyDto getSupply(@PathVariable("supplyId") int id) {
        logger.info("Getting supply...");
        return SupplyDto.toDto(supplyService.getById(id));
    }

    @PostMapping(value = "/supply")
    public SupplyDto create(@RequestBody SupplyDto dto, Principal principal) {
        logger.info("Creating supply...");
        Supply supply = SupplyDto.toEntity(dto);
        supply.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return SupplyDto.toDto(supplyService.create(supply));
    }

    @PutMapping(value = "/supply")
    public SupplyDto update(@RequestBody SupplyDto dto, Principal principal) {
        logger.info("Updating supply...");
        Supply supply = SupplyDto.toEntity(dto);
        supply.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return SupplyDto.toDto(supplyService.update(supply));
    }

    @DeleteMapping(value = "/supply/{supplyId}")
    public void delete(@PathVariable("supplyId") int id) {
        logger.info("Deleting supply...");
        supplyService.delete(id);
        logger.info("Deleted.");
    }

}
