package iwoom.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient {

    private RestTemplate restTemplate;

    @Autowired
    public RestClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String getById(String id, String url) {
        return restTemplate.getForObject(url + id, String.class);
    }
}
