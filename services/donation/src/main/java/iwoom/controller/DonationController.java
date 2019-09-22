package iwoom.controller;

import iwoom.model.DonationRequest;
import iwoom.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/money")
public class DonationController {

    private DonationService service;

    @Autowired
    public DonationController(DonationService service){
        this.service = service;
    }

    @PostMapping("/donate")
    public String createDonation(@RequestBody DonationRequest donationRequest){
        return service.donate(donationRequest);
    }
}
