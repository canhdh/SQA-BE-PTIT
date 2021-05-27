package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Loan;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
	List<Loan> findLoansByIdCustomer(int idCustomer);

	List<Loan> findLoansByStatusEquals(Integer status);
}
