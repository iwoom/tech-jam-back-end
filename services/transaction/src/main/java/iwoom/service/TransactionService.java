package iwoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class AccountService {

    @Value("${rest.client.url}")
    private String url;

    @Value("${td.api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    @Autowired
    public AccountService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getAccountByCustomer(String customerId){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url + String.format("/customers/%s/accounts", customerId),HttpMethod.GET, entity, String.class);
    }
}
