package com.example.demo.dto;

import com.example.demo.entities.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanDTO {
    private Integer id;
    private Integer idCustomer;
    private String purpose;
    private Double loanAmount;
    private String createdDate;
    private String dateBegin;
    private String expectedPaymentDate;
    private String collateral;
    private String proofOfCollateralDocument;
    private Double income;
    private String proofOfIncomeDocument;
    private Integer status;
    private Customer customer;
    private Double disbursedAmount;
    private String disbursementDate;
    private Double paidAmount;
}
