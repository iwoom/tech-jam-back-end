package iwoom.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jayway.jsonpath.JsonPath;
import iwoom.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Value("${rest.client.url}")
    private String url;

    @Value("${td.api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    @Autowired
    public CustomerService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    //public ResponseEntity<String> getCustomerById(String customerId){
    public Customer getCustomerById(String customerId){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url + String.format("/customers/%s", customerId),HttpMethod.GET, entity, String.class);
        Customer customer = retrieveCustomerInfo(response.getBody());

        //return restTemplate.exchange(url + String.format("/customers/%s", customerId),HttpMethod.GET, entity, String.class);

        return customer;
    }

    private Customer retrieveCustomerInfo(String response) {

        Customer customer = new Customer();
        try {
            customer.setType(JsonPath.read(response, "$.result.type"));
            customer.setId(JsonPath.read(response, "$.result.id"));
            customer.setAge(JsonPath.read(response, "$.result.age"));
            customer.setBirthDate(JsonPath.read(response, "$.result.birthDate"));
            customer.setGender(JsonPath.read(response, "$.result.gender"));
            customer.setGivenName(JsonPath.read(response, "$.result.givenName"));
            customer.setSurName(JsonPath.read(response, "$.result.surname"));
            customer.setTotalIncome(JsonPath.read(response, "$.result.totalIncome"));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        return customer;
    }
}
