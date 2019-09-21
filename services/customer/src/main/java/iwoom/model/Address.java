package iwoom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int addressType;
    private double latitude;
    private double longitude;
    private String municipality;
    private String postalCode;
    private String streetName;
    private String streetNumber;
}
