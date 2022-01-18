package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.dto.SupplyDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.supply.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SupplyController {

    private final SupplyService supplyService;

    @RequestMapping(value = "/supplies",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public List<SupplyDto> getSupplies(Principal principal) {
        return supplyService.getByUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).stream()
                .map(SupplyDto::toDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/supply/{supplyId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SupplyDto getSupply(@PathVariable("supplyId") int id) {
        return SupplyDto.toDto(supplyService.getById(id));
    }

    @RequestMapping(value = "/supply",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public SupplyDto create(@RequestBody SupplyDto dto, Principal principal) {
        Supply supply = SupplyDto.toEntity(dto);
        supply.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return SupplyDto.toDto(supplyService.create(supply));
    }

    @RequestMapping(value = "/supply",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public SupplyDto update(@RequestBody SupplyDto dto, Principal principal) {
        Supply supply = SupplyDto.toEntity(dto);
        supply.setUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return SupplyDto.toDto(supplyService.update(supply));
    }

    @RequestMapping(value = "/supply/{supplyId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("supplyId") int id) {
        supplyService.delete(id);
    }

}
