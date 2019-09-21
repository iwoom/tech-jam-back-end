package iwoom.service;

import iwoom.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Value("${rest.client.url}")
    private String url;

    @Value("$(td.api.key)")
    private String apiKey;

    private RestTemplate restTemplate;

    @Autowired
    public CustomerService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Customer getCustomer(String id){
        return restTemplate.getForObject(url + String.format("customers/%s", id), Customer.class);
    }
}
