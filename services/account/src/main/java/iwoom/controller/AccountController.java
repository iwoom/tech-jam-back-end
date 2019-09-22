package iwoom.controller;

import iwoom.model.Account;
import iwoom.model.Accounts;
import iwoom.service.AccountService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

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

//    private String getAccessToken() {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            return Base64.encodeBase64(md.digest(("salt" + ':' + "0QPSTzY4VlfllQs0NQdqJ4YqLRjot-hmpJZuLqB3SFo").getBytes()));
//        }catch(NoSuchAlgorithmException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
}

