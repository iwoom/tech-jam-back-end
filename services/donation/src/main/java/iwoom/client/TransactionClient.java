package iwoom.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionClient implements Client{

    @Value("${transaction.service.url}")
    private String url;

    private RestTemplate restTemplate;

    @Autowired
    public TransactionClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public String getById(String id) {
        return restTemplate.getForObject(url + id, String.class);
    }
}
