//package by.sam_solutions.grigorieva.olga.backend.controller.exception.test;
//
//import by.sam_solutions.grigorieva.olga.backend.exception.BusinessException;
//import by.sam_solutions.grigorieva.olga.backend.exception.Response;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//public class DeviceAdviceTest {
//
//    @GetMapping(value = "/testDefaultControllerAdvice", produces = APPLICATION_JSON_VALUE)
//    public Response testDefaultControllerAdvice(@RequestParam(required = false, defaultValue = "false") boolean exception)
//            throws BusinessException {
//        if (exception) {
//            throw new BusinessException("BusinessException in testDefaultControllerAdvice");
//        }
//        return new Response("OK");
//    }
//}

