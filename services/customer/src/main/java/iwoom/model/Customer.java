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
    private ArrayList<Address> addresses;
    private int age;
    private Date birthDate;
    private String gender;
    private String givenName;
    private String habitationStatus;
    private String maidenName;
    private String occupationIndustry;
    private String otherName;
    private String relationshipStatus;
    private String schoolAttendance;
    private ArrayList<String> schools;
    private String sureName;
    private double totalIncome;
    private String type;
    private String workActivity;
}
