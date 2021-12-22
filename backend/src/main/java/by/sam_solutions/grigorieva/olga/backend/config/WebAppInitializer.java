package by.sam_solutions.grigorieva.olga.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        return new Class<?>[]{WebAppInitializer.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
       return Persistence.createEntityManagerFactory("by.sam_solutions.grigorieva.olga.backend");
    }
}