package iwoom.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import iwoom.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AccountService {

    @Value("${rest.client.url}")
    private String url;

    @Value("${td.api.key}")
    private String apiKey;

    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    @Autowired
    public AccountService(RestTemplate restTemplate, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    //public ResponseEntity<String> getAccountByCustomer(String customerId){
    public Accounts getAccountByCustomer(String customerId){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url + String.format("/customers/%s/accounts", customerId),HttpMethod.GET, entity, String.class);

        Accounts accounts = retrieveAccountInformation(response.getBody());

        return accounts;
    }

    private Accounts retrieveAccountInformation(String response) {
        Accounts accounts = new Accounts();
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        ArrayList<CreditAccount> creditAccounts = new ArrayList<>();

        try{
            DocumentContext context = JsonPath.parse(response);
            int length = context.read("$.result.length()");

            //accounts = context.read("$.result");
            for(int i = 0; i < length; i++) {
                if(((HashMap<String, Object>)context.read("$.result")).keySet().toArray()[i].equals("bankAccounts")) {

                    int baLength = context.read("$.result.bankAccounts.length()");
                    for(int j = 0; j < baLength; j++) {
                        BankAccount bankAccount = new BankAccount();
                        bankAccount.setId(context.read("$.result.bankAccounts[" + j + "].id"));
                        bankAccount.setBranchNumber(Integer.parseInt(context.read("$.result.bankAccounts[" + j + "].branchNumber").toString()));
                        bankAccount.setBalance(Double.parseDouble(context.read("$.result.bankAccounts[" + j + "].balance").toString()));
                        bankAccount.setCustomerId(context.read("$.result.bankAccounts[" + j + "].relatedCustomerId"));
                        bankAccount.setMaskedAccountNumber(context.read("$.result.bankAccounts[" + j + "].maskedAccountNumber"));
                        bankAccount.setType(context.read("$.result.bankAccounts[" + j + "].type"));
                        bankAccount.setOpenDate(context.read("$.result.bankAccounts[" + j + "].openDate"));
                        bankAccount.setCurrency(context.read("$.result.bankAccounts[" + j + "].currency"));

                        bankAccounts.add(bankAccount);
                    }
                } else if (((HashMap<String, Object>)context.read("$.result")).keySet().toArray()[i].equals("creditCardAccounts")) {
                    int creLength = context.read("$.result.creditCardAccounts.length()");

                    for(int j = 0; j < creLength; j++) {
                        CreditAccount creditAccount = new CreditAccount();

                        Card card = new Card();
                        card.setAccountId(context.read("$.result.creditCardAccounts[" + j + "].card.accountId"));
                        card.setCustomerId(context.read("$.result.creditCardAccounts[" + j + "].card.customerId"));
                        card.setMaskedNumber(context.read("$.result.creditCardAccounts[" + j + "].card.maskedNumber"));
                        card.setNameOnCard(context.read("$.result.creditCardAccounts[" + j + "].card.nameOnCard"));
                        card.setSecurityCode(context.read("$.result.creditCardAccounts[" + j + "].card.securityCode"));

                        creditAccount.setCard(card);
                        creditAccount.setId(context.read("$.result.creditCardAccounts[" + j + "].id"));
                        creditAccount.setBalance(Double.parseDouble(context.read("$.result.creditCardAccounts[" + j + "].balance").toString()));
                        creditAccount.setCustomerId(context.read("$.result.creditCardAccounts[" + j + "].relatedCustomerId"));
                        creditAccount.setMaskedAccountNumber(context.read("$.result.creditCardAccounts[" + j + "].maskedNumber"));
                        creditAccount.setType(context.read("$.result.creditCardAccounts[" + j + "].type"));
                        creditAccount.setOpenDate(context.read("$.result.creditCardAccounts[" + j + "].openDate"));
                        creditAccount.setCurrency(context.read("$.result.creditCardAccounts[" + j + "].currency"));

                        creditAccounts.add(creditAccount);
                    }
                }
            }
            accounts.setBankAccounts(bankAccounts);
            accounts.setCreditAccounts(creditAccounts);
        } catch (Exception e){
            e.printStackTrace();
        }
        return accounts;
    }
}
