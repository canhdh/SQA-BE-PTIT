package com.example.demo.service;

import com.example.demo.dto.LoanDTO;
import com.example.demo.entities.Loan;

import java.util.List;

public interface LoanService {

    List<LoanDTO> getAllLoan();

    LoanDTO getLoanById(int id);

    List<LoanDTO> getLoanByIdCustomer(int idCustomer);

    LoanDTO createLoan(LoanDTO loanDTO);

    LoanDTO updateLoan(LoanDTO loanDTO);

}
