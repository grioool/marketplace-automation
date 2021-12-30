package by.sam_solutions.grigorieva.olga.backend.controller;

import java.util.List;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import by.sam_solutions.grigorieva.olga.backend.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    PurchaseController() {}

    @RequestMapping(value = "/purchases",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)


    public List<Purchase> getPurchases() {
        return purchaseRepository.getAll();
    }

    @RequestMapping(value = "/purchases/{purchaseId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Purchase getPurchase(@PathVariable("purchaseId") int id) {
        return purchaseRepository.getById(id);
    }

    @RequestMapping(value = "/purchase",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Purchase add(@RequestBody Purchase purchase) {
        return purchaseRepository.add(purchase);
    }

    @RequestMapping(value = "/purchase",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Purchase update(@RequestBody Purchase purchase) {
        return purchaseRepository.update(purchase);
    }

    @RequestMapping(value = "/purchase/{purchaseId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void delete(@PathVariable("purchaseId") int id) {
        purchaseRepository.delete(id);
    }

}