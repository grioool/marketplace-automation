package by.sam_solutions.grigorieva.olga.backend.service.wb;

import by.sam_solutions.grigorieva.olga.backend.domain.table.TablePage;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequiredArgsConstructor
public class WBService<Entity> {

    private final String url;

    public List<Entity> getByWBKey(User user) {

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
        headers.set(HttpHeaders.CONNECTION, "keep-alive");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        String urlTemplateOrders = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("dateFrom", "2022-01-20T21:00:00.000Z")
                .queryParam("flag", "0")
                .queryParam("key", user.getWildBerriesKeys())
                .toUriString();

        ResponseEntity<List<Entity>> response = restTemplate.exchange(urlTemplateOrders,
                HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});

        return response.getBody();
    }

    public TablePage<Entity> getByShift(User user, int shift, int rowsPerPage) {
        List<Entity> sales = getByWBKey(user);
        return new TablePage<>(sales.subList(shift, Math.min(sales.size(), shift + rowsPerPage)), sales.size());
    }
}
