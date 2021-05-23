package com.example.demo.service;

import com.example.demo.entities.Loan;

import java.util.List;

public interface LoanService {

    List<Loan> getAllLoan();

    Loan getLoanById(int id);

    List<Loan> getLoanByIdCustomer(int idCustomer);

    Loan createLoan(Loan loan);

    Loan updateLoan(Loan loan);

}
