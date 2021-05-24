package com.example.demo.dto;

import com.example.demo.entities.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanDTO {
    private int id;
    private int idCustomer;
    private String purpose;
    private int loanAmount;
    private String createdDate;
    private String dateBegin;
    private String exceptedPaymentDate;
    private String collateral;
    private String proofOfCollateralDocument;
    private float income;
    private String proofOfIncomeDocument;
    private int status;
    private Customer customer;
}
