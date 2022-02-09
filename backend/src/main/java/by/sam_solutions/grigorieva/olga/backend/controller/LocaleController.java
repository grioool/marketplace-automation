package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("locale")
public class LocaleController {

    @PostMapping
    public void setLocale() {
        System.out.println();
    }

    @GetMapping
    public void get()  {
        throw new BusinessException("user.not.found");
    }
}
