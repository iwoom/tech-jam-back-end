package iwoom.controller;

import iwoom.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private TransactionService service;

    @Autowired
    public TransactionController(TransactionService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTransactionsById(@PathVariable("id") String id) {
         return service.getTransactionById(id);
    }
}
