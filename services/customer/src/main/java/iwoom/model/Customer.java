package iwoom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String id;
    private int age;
    private Date birthDate;
    private String gender;
    private String givenName;
    private String maidenName;
    private String otherName;
    private String sureName;
    private double totalIncome;
}
