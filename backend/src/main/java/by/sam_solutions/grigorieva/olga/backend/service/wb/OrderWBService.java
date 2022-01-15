package by.sam_solutions.grigorieva.olga.backend.service.wb;

import by.sam_solutions.grigorieva.olga.backend.controller.auth.dto.OrderWBDto;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OrderWBService {

    static final String urlOrders = "https://suppliers-stats.wildberries.ru/api/v1/supplier/orders";

    public static void main(String[] args) {
        new OrderWBService().getOrders();
    }

    public OrderWBDto getOrders() {

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.ALL_VALUE);
        headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
        headers.set(HttpHeaders.CONNECTION, "keep-alive");
        HttpEntity<String> entity = new HttpEntity<>("", headers);

        RestTemplate restTemplate = new RestTemplate();
//https://suppliers-stats.wildberries.ru/api/v1/supplier/orders?
//dateFrom=2021-12-21T21%3A00%3A00.000Z&flag=0&key=N2IwNWY3M2MtYjBhYy00YWJiLWFlNmYtZjZmZTU2YWRlMDc3
        String urlTemplateSales = UriComponentsBuilder.fromHttpUrl(urlOrders)
                .queryParam("dateFrom", "2021-12-21T21%3A00%3A00.000Z")
                .queryParam("flag", "0")
                .queryParam("key", "N2IwNWY3M2MtYjBhYy00YWJiLWFlNmYtZjZmZTU2YWRlMDc3")
                .toUriString();

        Map<String, String> params = new HashMap<>();
        params.put("dateFrom", "2017-03-25T21%3A00%3A00.000Z");
        params.put("flag", "0");
        params.put("key", "N2IwNWY3M2MtYjBhYy00YWJiLWFlNmYtZjZmZTU2YWRlMDc3");

        ResponseEntity<OrderWBDto> responseOrders = restTemplate.exchange(
                urlTemplateSales,
                HttpMethod.GET,
                entity,
                OrderWBDto.class);

        return responseOrders.getBody();
    }
}