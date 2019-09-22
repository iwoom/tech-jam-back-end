package iwoom.service;

import iwoom.client.TransactionClient;
import iwoom.model.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService {

    private TransactionClient txnClient;

    @Autowired
    public DonationService(TransactionClient txnClient){
        this.txnClient = txnClient;
    }

    public String calculateDonationAmount(Donation donation){
        return txnClient.getById(donation.getTransactionId());
        //GetCustomer Ratio
        //store in database

    }
}
