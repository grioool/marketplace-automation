package by.sam_solutions.grigorieva.olga.backend.config;

import by.sam_solutions.grigorieva.olga.backend.converter.to.dto.*;
import by.sam_solutions.grigorieva.olga.backend.converter.to.entity.*;
import by.sam_solutions.grigorieva.olga.backend.converter.to.report.ReportWBDtoToReportDtoConverter;
import by.sam_solutions.grigorieva.olga.backend.service.profit.ProfitService;
import by.sam_solutions.grigorieva.olga.backend.service.supply.SupplyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.List;
import java.util.Locale;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    private final ConversionService mConversionService;

    private final SupplyService supplyService;

    private final ProfitService profitService;

    @Autowired
    public WebConfig(@Lazy ConversionService conversionService, SupplyService supplyService, ProfitService profitService) {
        mConversionService = conversionService;
        this.supplyService = supplyService;
        this.profitService = profitService;
    }

    public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate5Module());

        messageConverter.setObjectMapper(mapper);
        return messageConverter;

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CountryToDtoConverter());
        registry.addConverter(new PurchaseToDtoConverter());
        registry.addConverter(new ReportToDtoConverter(mConversionService));
        registry.addConverter(new RoleToDtoConverter());
        registry.addConverter(new StorageToDtoConverter(mConversionService));
        registry.addConverter(new SupplyToDtoConverter(mConversionService));
        registry.addConverter(new TownToDtoConverter());
        registry.addConverter(new UserToDtoConverter());
        registry.addConverter(new CountryToEntityConverter());
        registry.addConverter(new PurchaseToEntityConverter());
        registry.addConverter(new ReportToEntityConverter(mConversionService));
        registry.addConverter(new RoleToEntityConverter());
        registry.addConverter(new StorageToEntityConverter(mConversionService));
        registry.addConverter(new SupplyToEntityConverter(mConversionService));
        registry.addConverter(new TownToEntityConverter());
        registry.addConverter(new UserToEntityConverter());
        registry.addConverter(new ReportWBDtoToReportDtoConverter(mConversionService, supplyService, profitService));
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.ENGLISH);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
