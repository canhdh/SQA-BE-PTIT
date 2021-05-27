package com.example.demo.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Integer idCustomer;
	@Column
	private String purpose;
	@Column
	private Double loanAmount;
	@Column
	private String createdDate;
	@Column
	private String dateBegin;
	@Column
	private String expectedPaymentDate;
	@Column
	private String collateral;
	@Column
	private String proofOfCollateralDocument;
	@Column
	private Double income;
	@Column
	private String proofOfIncomeDocument;
	@Column
	private Integer status;
	@Column
	private Double disbursedAmount;
	@Column
	private String disbursementDate;
	@Column
	private Double paidAmount;
}
