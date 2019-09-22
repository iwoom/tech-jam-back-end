package iwoom.controller;

import iwoom.model.Donation;
import iwoom.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/money")
public class MoneyController {

    private DonationService service;

    @Autowired
    public MoneyController(DonationService service){
        this.service = service;
    }

    @PostMapping("/donate")
    public String createDonation(@RequestBody Donation donation){
        return service.calculateDonationAmount(donation);
    }
}
