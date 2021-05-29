package com.ptit.sqa.loan_management_system.dto;

import com.ptit.sqa.loan_management_system.entity.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanDto {
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
