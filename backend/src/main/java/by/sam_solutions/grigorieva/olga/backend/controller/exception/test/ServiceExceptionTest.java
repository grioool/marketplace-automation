package by.sam_solutions.grigorieva.olga.backend.controller.exception.test;

import by.sam_solutions.grigorieva.olga.backend.exception.ServiceException;
import com.sun.mail.iap.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ServiceExceptionTest {

    @GetMapping(value = "/testResponseStatusExceptionResolver", produces = APPLICATION_JSON_VALUE)
    public Response testResponseStatusExceptionResolver(@RequestParam(required = false, defaultValue = "false") boolean exception)
            throws ServiceException {
        if (exception) {
            throw new ServiceException("ServiceException in testResponseStatusExceptionResolver");
        }
        return new Response("OK");
    }
}
