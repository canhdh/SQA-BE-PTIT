package com.ptit.sqa.loan_management_system.service.impl;

import com.ptit.sqa.loan_management_system.dto.LoanDto;
import com.ptit.sqa.loan_management_system.entity.Loan;
import com.ptit.sqa.loan_management_system.repository.LoanRepository;
import com.ptit.sqa.loan_management_system.service.CustomerService;
import com.ptit.sqa.loan_management_system.service.LoanService;
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
    public List<LoanDto> getAllLoan() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public LoanDto getLoanById(int id) {
        return this.toDTO(Objects.requireNonNull(repository.findById(id).orElse(null)));
    }

    @Override
    public List<LoanDto> getLoanByIdCustomer(Integer idCustomer) {
        return repository.findLoansByIdCustomer(idCustomer).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<LoanDto> getLoanByStatus(Integer status) {
        return repository.findLoansByStatusEquals(status).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public LoanDto createLoan(LoanDto loanDTO) {
        loanDTO.setStatus(1);
        loanDTO.setCreatedDate(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        loanDTO.setDisbursementDate(null);
        loanDTO.setDisbursedAmount(0.0);
        loanDTO.setPaidAmount(0.0);
        return this.toDTO(repository.save(this.toEntity(loanDTO)));
    }

    @Override
    public LoanDto updateLoan(LoanDto loanDTO) {
        return this.toDTO(repository.save(this.toEntity(loanDTO)));
    }

    private LoanDto toDTO(Loan loan) {
        return LoanDto.builder()
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

    private Loan toEntity(LoanDto loanDTO) {
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
