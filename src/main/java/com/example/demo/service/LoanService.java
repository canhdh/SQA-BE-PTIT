package com.example.demo.service;

import com.example.demo.dto.LoanDTO;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface LoanService {

    List<LoanDTO> getAllLoan();

    LoanDTO getLoanById(int id);

    List<LoanDTO> getLoanByIdCustomer(Integer idCustomer);

    List<LoanDTO> getLoanByStatus(Integer status);

    LoanDTO createLoan(LoanDTO loanDTO);

    LoanDTO updateLoan(LoanDTO loanDTO);

}
