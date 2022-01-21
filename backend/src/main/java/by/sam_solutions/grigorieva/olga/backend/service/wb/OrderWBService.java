package by.sam_solutions.grigorieva.olga.backend.service.wb;

import by.sam_solutions.grigorieva.olga.backend.dto.OrderWBDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderWBService extends WBService<OrderWBDto> {

    public OrderWBService(@Value("${url.orders}") String url) {
        super(url);
    }
}
