package iwoom.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerClient implements Client {

    private RestTemplate restTemplate;

    @Autowired
    public CustomerClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public String getById(String id) {
        return null;
    }
}
