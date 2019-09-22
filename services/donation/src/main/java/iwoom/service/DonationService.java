package iwoom.service;

import com.jayway.jsonpath.JsonPath;
import iwoom.client.RestClient;
import iwoom.model.Donation;
import iwoom.model.DonationRequest;
import iwoom.repo.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;

@Service
public class DonationService {

    @Value("${transaction.service.url}")
    private String txnUrl;

    private DonationRepository donationRepository;
    private RestClient client;

    @Autowired
    public DonationService(RestClient client, DonationRepository donationRepository){
        this.client = client;
        this.donationRepository = donationRepository;
    }

    public String donate(DonationRequest donationRequest){
        String transaction = client.getById(donationRequest.getTransactionId(), txnUrl);
        //GetCustomer Ratio
        BigDecimal amount = calculateDonationAmount(transaction, 0.05);
        //store in database
        Donation donation = Donation.builder()
                .description("Test Donation")
                .amount(amount)
                .donationDate(Date.valueOf(LocalDate.now()))
                .build();
        Donation donationResponse = donationRepository.save(donation);
        return donation.toString();
        //request interac
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
