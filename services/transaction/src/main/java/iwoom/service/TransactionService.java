package iwoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class TransactionService {

    @Value("${rest.client.url}")
    private String url;

    @Value("${td.api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    @Autowired
    public TransactionService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getTransactionById(String transId){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> result = restTemplate.exchange(url + String.format("/transactions/%s", transId),HttpMethod.GET, entity, String.class);

        return result;
    }
}
