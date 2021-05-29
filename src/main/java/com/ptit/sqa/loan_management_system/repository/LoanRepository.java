package com.ptit.sqa.loan_management_system.repository;

import com.ptit.sqa.loan_management_system.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
	List<Loan> findLoansByIdCustomer(Integer idCustomer);

	List<Loan> findLoansByStatusEquals(Integer status);
}
