package iwoom.service;

import com.jayway.jsonpath.JsonPath;
import iwoom.client.RestClient;
import iwoom.model.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DonationService {

    @Value("${transaction.service.url}")
    private String txnUrl;

    private RestClient client;

    @Autowired
    public DonationService(RestClient client){
        this.client = client;
    }

    public String donate(Donation donation){
        String transaction = client.getById(donation.getTransactionId(), txnUrl);
        //GetCustomer Ratio
        BigDecimal amount = calculateDonationAmount(transaction, 0.05);
        //store in database
        return transaction;
    }

    private BigDecimal calculateDonationAmount(String transaction, double donationMultiple){
        BigDecimal donationMultipleBd = new BigDecimal(donationMultiple);
        BigDecimal transactionAmount = BigDecimal.valueOf((Double)JsonPath.read(transaction, "$.result.currencyAmount"));
        BigDecimal divided = transactionAmount.divide(donationMultipleBd, 0, RoundingMode.UP);
        BigDecimal grossTransaction = divided.multiply(donationMultipleBd);
        BigDecimal donationAmount = grossTransaction.subtract(transactionAmount);
        return donationAmount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
}
