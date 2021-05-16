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
public class DebtSlip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IDDebtSlip;
	@Column
	private int IDCustomer;
	@Column
	private String description;
	@Column
	private int loan;
	@Column
	private String date;
	@Column
	private String dateBegin;
	@Column
	private String dateEnd;
	@Column
	private String collateral;
	@Column
	private String pooDoc;
	@Column
	private int income;
	@Column
	private String poIncome;
	@Column
	private String status;
}
