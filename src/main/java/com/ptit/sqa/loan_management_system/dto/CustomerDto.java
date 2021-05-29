package com.ptit.sqa.loan_management_system.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private int id;
    private String username;
    private String name;
    private String email;
    private String birthday;
    private String address;
    private String gender;
    private String phoneNumber;
    private String idCard;
    private String nationality;
    private String maritalStatus;
}
