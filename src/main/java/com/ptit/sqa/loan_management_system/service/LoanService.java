package com.ptit.sqa.loan_management_system.service;

import com.ptit.sqa.loan_management_system.dto.LoanDto;

import java.util.List;

public interface LoanService {

    List<LoanDto> getAllLoan();

    LoanDto getLoanById(int id);

    List<LoanDto> getLoanByIdCustomer(Integer idCustomer);

    List<LoanDto> getLoanByStatus(Integer status);

    LoanDto createLoan(LoanDto loanDTO);

    LoanDto updateLoan(LoanDto loanDTO);

}
