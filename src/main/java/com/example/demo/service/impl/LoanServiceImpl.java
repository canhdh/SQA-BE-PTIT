package com.example.demo.service.impl;

import com.example.demo.dto.LoanDTO;
import com.example.demo.entities.Loan;
import com.example.demo.repository.LoanRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.LoanService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository repository;
    private final CustomerService customerService;

    public LoanServiceImpl(LoanRepository repository, CustomerService customerService) {
        this.repository = repository;
        this.customerService = customerService;
    }

    @Override
    public List<LoanDTO> getAllLoan() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public LoanDTO getLoanById(int id) {
        return this.toDTO(Objects.requireNonNull(repository.findById(id).orElse(null)));
    }

    @Override
    public List<LoanDTO> getLoanByIdCustomer(int idCustomer) {
        return repository.findLoansByIdCustomer(idCustomer).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<LoanDTO> getLoanByStatus(Integer status) {
        return repository.findLoansByStatusEquals(status).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public LoanDTO createLoan(LoanDTO loanDTO) {
        loanDTO.setStatus(1);
        loanDTO.setCreatedDate(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        loanDTO.setDisbursementDate(null);
        loanDTO.setDisbursedAmount(0.0);
        loanDTO.setPaidAmount(0.0);
        return this.toDTO(repository.save(this.toEntity(loanDTO)));
    }

    @Override
    public LoanDTO updateLoan(LoanDTO loanDTO) {
        return this.toDTO(repository.save(this.toEntity(loanDTO)));
    }

    private LoanDTO toDTO(Loan loan) {
        return LoanDTO.builder()
                .collateral(loan.getCollateral())
                .createdDate(loan.getCreatedDate())
                .customer(customerService.getCustomerById(loan.getIdCustomer()))
                .dateBegin(loan.getDateBegin())
                .expectedPaymentDate(loan.getExpectedPaymentDate())
                .loanAmount(loan.getLoanAmount())
                .id(loan.getId())
                .idCustomer(loan.getIdCustomer())
                .income(loan.getIncome())
                .proofOfIncomeDocument(loan.getProofOfIncomeDocument())
                .proofOfCollateralDocument(loan.getProofOfCollateralDocument())
                .disbursedAmount(loan.getDisbursedAmount())
                .paidAmount(loan.getPaidAmount())
                .disbursementDate(loan.getDisbursementDate())
                .purpose(loan.getPurpose())
                .status(loan.getStatus())
                .build();
    }

    private Loan toEntity(LoanDTO loanDTO) {
        Loan loan = new Loan();
        loan.setId(loanDTO.getId());
        loan.setIdCustomer(loanDTO.getIdCustomer());
        loan.setCreatedDate(loanDTO.getCreatedDate());
        loan.setDateBegin(loanDTO.getDateBegin());
        loan.setExpectedPaymentDate(loanDTO.getExpectedPaymentDate());
        loan.setLoanAmount(loanDTO.getLoanAmount());
        loan.setCollateral(loanDTO.getCollateral());
        loan.setIncome(loanDTO.getIncome());
        loan.setProofOfCollateralDocument(loanDTO.getProofOfCollateralDocument());
        loan.setProofOfIncomeDocument(loanDTO.getProofOfIncomeDocument());
        loan.setPaidAmount(loanDTO.getPaidAmount());
        loan.setDisbursementDate(loanDTO.getDisbursementDate());
        loan.setDisbursedAmount(loanDTO.getDisbursedAmount());
        loan.setStatus(loanDTO.getStatus());
        loan.setPurpose(loanDTO.getPurpose());
        return loan;
    }
}
