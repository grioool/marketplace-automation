package by.sam_solutions.grigorieva.olga.backend.controller.exception.test;

import by.sam_solutions.grigorieva.olga.backend.exception.ResponseStatusException;
import com.sun.mail.iap.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ResponseStatusExceptionTest {

    @GetMapping(value = "/testResponseStatusException", produces = APPLICATION_JSON_VALUE)
    public Response testResponseStatusException(@RequestParam(required = false, defaultValue = "false") boolean exception) throws ResponseStatusException {
        if (exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "ResponseStatusException in testResponseStatusException");
        }
        return new Response("OK");
    }
}
