package by.sam_solutions.grigorieva.olga.backend.service.wb;

import by.sam_solutions.grigorieva.olga.backend.dto.SaleWBDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class SaleWBService {

    public static void main(String[] args) {
        new SaleWBService().getSales();
    }

    static final String urlSales = "https://suppliers-stats.wildberries.ru/api/v1/supplier/sales";

        public List<SaleWBDto> getSales() {

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
        headers.set(HttpHeaders.CONNECTION, "keep-alive");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        String urlTemplateSales = UriComponentsBuilder.fromHttpUrl(urlSales)
                .queryParam("dateFrom", "2022-01-15T21:00:00.000Z")
                .queryParam("flag", "0")
                .queryParam("key", "N2IwNWY3M2MtYjBhYy00YWJiLWFlNmYtZjZmZTU2YWRlMDc3")
                .toUriString();

        ResponseEntity<List<SaleWBDto>> responseSales = restTemplate.exchange(urlTemplateSales,
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<SaleWBDto>>() {});

            return responseSales.getBody();
    }
}
