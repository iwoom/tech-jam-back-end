package iwoom.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import iwoom.model.Account;
import iwoom.model.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Value("${rest.client.url}")
    private String url;

    @Value("${td.api.key}")
    private String apiKey;

    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    @Autowired
    public AccountService(RestTemplate restTemplate, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Accounts getAccountByCustomer(String customerId){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url + String.format("/customers/%s/accounts", customerId),HttpMethod.GET, entity, String.class);
        Accounts accounts = retrieveAccountInformation(response.getBody());
        return accounts;
    }

    private Accounts retrieveAccountInformation(String response) {
        Accounts accounts = new Accounts();
        List<String> accountsJson = JsonPath.read(response, "$.result.bankAccounts");
        try{
            for(int i = 0; i < accountsJson.size(); i++) {
                Account account = objectMapper.readValue(accountsJson.get(i), Account.class);
                accounts.getAccounts().add(account);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return accounts;
    }
}
