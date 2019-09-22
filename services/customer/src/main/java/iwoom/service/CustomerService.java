package iwoom.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import iwoom.model.Customer;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
//        ObjectMapper mapper = new ObjectMapper();
//
//        String customerJSON =  JsonPath.read(response, "$.result").toString();
//
        Customer customer = new Customer();
//
//        try {
//            customer = new ObjectMapper().readValue(customerJSON, Customer.class);
//        } catch (Exception e) {
//            System.out.println(e.getStackTrace());
//        }



        return customer;
    }
}
