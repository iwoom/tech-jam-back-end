package iwoom.controller;

import iwoom.model.Transaction;
import iwoom.repo.TransactionRepo;
import iwoom.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private TransactionService service;
    private TransactionRepo transactionRepo;



    @Autowired
    public TransactionController(TransactionService service, TransactionRepo transactionRepo){
        this.service = service;
        this.transactionRepo = transactionRepo;
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> getTransactionsById(@PathVariable("id") String id) {
         return service.getTransactionById(id);
    }



    @GetMapping(path="/all")
    public @ResponseBody Iterable<Transaction> getTransactionHistory() {
        return transactionRepo.findAll();
    }
}
