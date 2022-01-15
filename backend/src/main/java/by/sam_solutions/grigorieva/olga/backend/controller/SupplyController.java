package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.supply.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SupplyController {

    private final SupplyService supplyService;

    @RequestMapping(value = "/supplies",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Supply> getSupplies(Principal principal) {
        return supplyService.getByUser((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
    }

    @RequestMapping(value = "/supply/{supplyId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Supply getSupply(@PathVariable("supplyId") int id) {
        return supplyService.getById(id);
    }

    @RequestMapping(value = "/supply",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Supply create(@RequestBody Supply supply) {
        return supplyService.create(supply);
    }

    @RequestMapping(value = "/supply",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Supply update(@RequestBody Supply supply) {
        return supplyService.update(supply);
    }

    @RequestMapping(value = "/supply/{supplyId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void delete(@PathVariable("supplyId") int id) {
        supplyService.delete(id);
    }

}
