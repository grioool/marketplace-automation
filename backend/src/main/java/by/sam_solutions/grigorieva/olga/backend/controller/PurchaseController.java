package by.sam_solutions.grigorieva.olga.backend.controller;

import java.util.List;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import by.sam_solutions.grigorieva.olga.backend.exception.ServiceException;
import by.sam_solutions.grigorieva.olga.backend.service.purchase.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping(value = "/purchases")

    public List<Purchase> getPurchases() {
        return purchaseService.getAll();
    }

    @RequestMapping(value = "/purchase/{purchaseId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Purchase getPurchase(@PathVariable("purchaseId") int id, boolean exception) throws ServiceException {
            if (exception) {
                throw new ServiceException("ServiceException in testResponseStatusExceptionResolver");
            }

//        if ("error".equals(id)) {
//            // go handleCustomException
//            throw new CustomException("E888", "This is custom message");
//        } else if ("io-error".equals(id)) {
//            // go handleAllException
//            throw new IOException();
//        } else {
//            return new ModelAndView("index").addObject("msg", id);
//        }

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