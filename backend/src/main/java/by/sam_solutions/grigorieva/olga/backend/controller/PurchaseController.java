package by.sam_solutions.grigorieva.olga.backend.controller;

import java.util.List;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import by.sam_solutions.grigorieva.olga.backend.service.purchase.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/purchases",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Purchase> getPurchases() {
        return purchaseService.getAll();
    }

    @RequestMapping(value = "/purchases/{purchaseId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Purchase getPurchase(@PathVariable("purchaseId") int id) {
        return purchaseService.getById(id);
    }

    @RequestMapping(value = "/purchase",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Purchase create(@RequestBody Purchase purchase) {
        return purchaseService.create(purchase);
    }

    @RequestMapping(value = "/purchase",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Purchase update(@RequestBody Purchase purchase) {
        return purchaseService.update(purchase);
    }

    @RequestMapping(value = "/purchase/{purchaseId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void delete(@PathVariable("purchaseId") int id) {
        purchaseService.delete(id);
    }

}