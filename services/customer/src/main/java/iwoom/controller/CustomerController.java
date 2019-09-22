package iwoom.controller;

import iwoom.model.Customer;
import iwoom.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Customer getCustomer(@PathVariable("id") String id) {
    //public ResponseEntity<String> getCustomer(@PathVariable("id") String id) {
        return service.getCustomerById(id);
    }
}
