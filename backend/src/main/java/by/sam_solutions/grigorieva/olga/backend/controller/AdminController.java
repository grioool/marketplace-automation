package by.sam_solutions.grigorieva.olga.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping
public class AdminController {



    @GetMapping("/hello")
    public String hello() {
        return "string";
    }

}
