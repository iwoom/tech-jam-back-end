package iwoom.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @JsonProperty("id")
    private String id;

    @JsonProperty("age")
    private int age;

    @JsonProperty("birthDate")
    private Date birthDate;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("givenName")
    private String givenName;

    @JsonProperty("maidenName")
    private String maidenName;

    @JsonProperty("otherName")
    private String otherName;

    @JsonProperty("sureName")
    private String sureName;

    @JsonProperty("totalIncome")
    private double totalIncome;
}
