package iwoom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {
    private String securityCode;
    private String maskedNumber;
    private String customerId;
    private String accountId;
    private String nameOnCard;
}