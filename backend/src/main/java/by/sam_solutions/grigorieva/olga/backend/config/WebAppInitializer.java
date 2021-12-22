package by.sam_solutions.grigorieva.olga.backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//TODO - CRUD для закупок
//TODO - сделать этот CRUD на фронте
//TODO - подключить Spring Security c jwt токеном
//TODO - реализовать  логин, регистрацию
//TODO - реализовать всю авторизацию на фронте
//TODO - создание сущности "Поставки" и "Отчёт", наладить связи между ними

@Configuration
@EnableWebMvc
@ComponentScan("by.sam_solutions.grigorieva.olga.backend")
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public WebAppInitializer() {}

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{HibernateConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }
}