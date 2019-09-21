package iwoom.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    @JsonProperty("id")
    private String id;

    @JsonProperty
    private String customerId;
    private String maskedAccountNumber;
    private String type;
    private String currency;
    private double balance;
}
