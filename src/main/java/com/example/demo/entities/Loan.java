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
	private int id;
	@Column
	private int idCustomer;
	@Column
	private String purpose;
	@Column
	private int loanAmount;
	@Column
	private String createdDate;
	@Column
	private String dateBegin;
	@Column
	private String exceptedPaymentDate;
	@Column
	private String collateral;
	@Column
	private String proofOfCollateralDocument;
	@Column
	private float income;
	@Column
	private String proofOfIncomeDocument;
	@Column
	private int status;
}
