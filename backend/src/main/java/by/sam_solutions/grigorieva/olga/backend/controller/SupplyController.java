package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.domain.table.TablePage;
import by.sam_solutions.grigorieva.olga.backend.dto.SupplyDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.supply.SupplyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SupplyController {

    private final SupplyService supplyService;
    private final Logger logger = LoggerFactory.getLogger(SupplyController.class);
    private final ConversionService conversionService;

    @GetMapping(value = "/supplies")
    public  ResponseEntity<List<SupplyDto>> getSupplies(Principal principal) {
        logger.info("Getting supplies...");
        return new ResponseEntity<>(supplyService.getByUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).stream()
                .map(supply -> conversionService.convert(supply, SupplyDto.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/suppliesbypage")
    public TablePage<SupplyDto> getUsersByPage(@RequestParam Integer shift, @RequestParam Integer rowsPerPage, Principal principal) {
        logger.info("Getting supplies by page...");
        TablePage<Supply> page = supplyService.getSuppliesPerPage(getUser(principal), shift, rowsPerPage);
        return new TablePage<>(
                page.getItems().stream()
                        .map(supply -> conversionService.convert(supply, SupplyDto.class))
                        .collect(Collectors.toList()),
                page.getTotalCount()
        );
    }

    @GetMapping(value = "/supply/{supplyId}")
    public ResponseEntity<SupplyDto> getSupply(@PathVariable("supplyId") int id) {
        logger.info("Getting supply...");
        return new ResponseEntity<>(conversionService.convert(supplyService.getById(id), SupplyDto.class), HttpStatus.OK);
    }

    @PostMapping(value = "/supply")
    public ResponseEntity<SupplyDto> create(@RequestBody @Valid SupplyDto supplyDto, Principal principal) {
        logger.info("Creating supply...");
        Supply supply = conversionService.convert(supplyDto, Supply.class);
        supply.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return new ResponseEntity<>(conversionService.convert(supplyService.create(supply), SupplyDto.class), HttpStatus.OK);
    }

    @PutMapping(value = "/supply")
    public ResponseEntity<SupplyDto> update(@RequestBody SupplyDto supplyDto, Principal principal) {
        logger.info("Updating supply...");
        Supply supply = conversionService.convert(supplyDto, Supply.class);
        supply.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return new ResponseEntity<>(conversionService.convert(supplyService.update(supply), SupplyDto.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/supply/{supplyId}")
    public void delete(@PathVariable("supplyId") int id) {
        logger.info("Deleting supply...");
        supplyService.delete(id);
        logger.info("Deleted.");
    }

    private User getUser(Principal principal) {
        return (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
    }

}
