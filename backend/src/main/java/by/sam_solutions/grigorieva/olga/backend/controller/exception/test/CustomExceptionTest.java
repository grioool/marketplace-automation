//package by.sam_solutions.grigorieva.olga.backend.controller.exception.test;
//
//import by.sam_solutions.grigorieva.olga.backend.exception.BusinessException;
//import by.sam_solutions.grigorieva.olga.backend.exception.CustomExceptionHandler;
//import com.sun.mail.iap.Response;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//
//@RestController
//@CustomExceptionHandler
//public class CustomExceptionTest {
//
//    @GetMapping(value = "/testCustomControllerAdvice", produces = APPLICATION_JSON_VALUE)
//    public Response testCustomControllerAdvice(@RequestParam(required = false, defaultValue = "false") boolean exception)
//            throws BusinessException {
//        if (exception) {
//            throw new BusinessException("BusinessException in testCustomControllerAdvice");
//        }
//        return new Response("OK");
//    }
//}
