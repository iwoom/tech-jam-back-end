package iwoom.controller;

import iwoom.model.Accounts;
import iwoom.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService service;

    @Autowired
    public AccountController(AccountService service){
        this.service = service;
    }

    @GetMapping("/customerid/{id}")
    public Accounts getAccountByCustomer(@PathVariable("id") String id) {
         return service.getAccountByCustomer(id);
    }
}
