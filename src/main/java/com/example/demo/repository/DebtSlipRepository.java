package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Customer;
import com.example.demo.entities.DebtSlip;

public interface DebtSlipRepository extends CrudRepository<DebtSlip, Integer>{
	
}
