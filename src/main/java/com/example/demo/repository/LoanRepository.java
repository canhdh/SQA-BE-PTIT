package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Loan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
	List<Loan> findLoansByIdCustomer(Integer idCustomer);

	List<Loan> findLoansByStatusEquals(Integer status);
}
