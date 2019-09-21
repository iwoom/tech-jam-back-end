package iwoom.controller;

import iwoom.service.AccountService;
import iwoom.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAccountByCustomer(@PathVariable("id") String id) {
        return service.getCustomerById(id);
    }
}
