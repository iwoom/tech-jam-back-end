package iwoom.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    private String id;
    private float currencyAmount;
    private String customerId;
    private String description;
    private String locationCity;
    private String locationCountry;
    private float locationLatitude;
    private float locationLongitude;
    private String locationPostalCode;
    private String locationRegion;
    private String locationStreet;
    private int merchantCategoryCode;
    private String merchantId;
    private String merchantName;
    private String originationDateTime;
    private String source;
    private String type;
    private String trans_date;

}

