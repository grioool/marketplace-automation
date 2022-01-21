package by.sam_solutions.grigorieva.olga.backend.service.wb;

import by.sam_solutions.grigorieva.olga.backend.dto.SaleWBDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SaleWBService extends WBService<SaleWBDto> {

    public SaleWBService(@Value("${url.sales}") String url) {
        super(url);
    }
}
