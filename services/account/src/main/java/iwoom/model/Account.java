package iwoom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private String id;
    private String customerId;
    private String maskedAccountNumber;
    private String type;
    private String currency;
    private double balance;
}
