//package by.sam_solutions.grigorieva.olga.backend.controller;
//
//import by.sam_solutions.grigorieva.olga.backend.exception.BusinessException;
//import org.springframework.dao.DataAccessException;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.sql.SQLException;
//
//@ControllerAdvice
//public class ExceptionHandlingController {
//
//    @ResponseStatus(value= HttpStatus.CONFLICT,
//            reason="Data integrity violation")  // 409
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public void conflict() {
//    }
//
//    @ExceptionHandler({SQLException.class, DataAccessException.class})
//    public String databaseError() {
//        return "databaseError";
//    }
//
//    @ExceptionHandler(BusinessException.class)
//    public ModelAndView handleCustomException(BusinessException ex) {
//
//        ModelAndView model = new ModelAndView("error/custom_error");
//        model.addObject("errorCode", ex.getErrorCode());
//        model.addObject("errorMsg", ex.getErrorMsg());
//        model.setViewName("error");
//
//        return model;
//
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleAllException(Exception ex) {
//
//        ModelAndView model = new ModelAndView("error/custom_error");
//        model.addObject("errorMsg", "this is Exception.class");
//
//        return model;
//
//    }
//}
