package com.example.demo.service.impl;

import com.example.demo.entities.Loan;
import com.example.demo.repository.LoanRepository;
import com.example.demo.service.LoanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository repository;

    public LoanServiceImpl(LoanRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Loan> getAllLoan() {
        return (List<Loan>) repository.findAll();
    }

    @Override
    public Loan getLoanById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Loan> getLoanByIdCustomer(int idCustomer) {
        return repository.findLoansByIdCustomer(idCustomer);
    }

    @Override
    public Loan createLoan(Loan loan) {
        return repository.save(loan);
    }

    @Override
    public Loan updateLoan(Loan loan) {
        return repository.save(loan);
    }
}
