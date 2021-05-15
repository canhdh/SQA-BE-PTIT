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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IDCustomer;
	@Column
	private String username;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String dateBorn;
	@Column
	private String form;
	@Column
	private String sex;
	@Column
	private String numberPhone;
	@Column
	private String cmnd;
	@Column
	private String nationality;
	@Column
	private String maritalStatus;
}