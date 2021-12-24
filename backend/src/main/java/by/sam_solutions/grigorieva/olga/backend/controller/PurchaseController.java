package by.sam_solutions.grigorieva.olga.backend.controller;

import java.util.List;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import by.sam_solutions.grigorieva.olga.backend.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    PurchaseController() {}

    @RequestMapping(value = "/purchases",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public List<Purchase> getPurchases() {
        return purchaseService.getAll();
    }

    @RequestMapping(value = "/purchases/{purchaseNo}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Purchase getPurchase(@PathVariable("purchaseNo") String purchaseN) {
        return purchaseService.getByName(purchaseN);
    }

    @RequestMapping(value = "/purchase", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Purchase add(@RequestBody Purchase purchase) {
        return purchaseService.add(purchase);
    }

    @RequestMapping(value = "purchase", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Purchase update(@RequestBody Purchase purchase) {

        return purchaseService.update(purchase);
    }

    @RequestMapping(value = "/purchases/{purchaseNo}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void delete(@PathVariable("purchaseNo") Purchase purchase) {
        purchaseService.delete(purchase);
    }

}