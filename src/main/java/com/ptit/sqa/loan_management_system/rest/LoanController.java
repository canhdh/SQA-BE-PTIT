package com.ptit.sqa.loan_management_system.rest;

import java.util.List;

import com.ptit.sqa.loan_management_system.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ptit.sqa.loan_management_system.dto.LoanDto;

@RestController
@RequestMapping(path = "/loan", produces = "application/json")
@CrossOrigin(origins = "*")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<?> getAllLoan() {
        return ResponseEntity.ok(loanService.getAllLoan());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        LoanDto loan = loanService.getLoanById(id);
        return ResponseEntity.ok(loan);
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<?> getLoanByIdCustomer(@PathVariable int idCustomer) {
        List<LoanDto> loans = loanService.getLoanByIdCustomer(idCustomer);
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/status")
    public ResponseEntity<?> getLoanByStatus(@RequestParam Integer status) {
        List<LoanDto> loans = loanService.getLoanByStatus(status);
        return ResponseEntity.ok(loans);
    }

    @PostMapping
    public ResponseEntity<?> addLoan(@RequestBody LoanDto loanDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(loanDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLoan(@PathVariable int id, @RequestBody LoanDto loanDTO) {
        return ResponseEntity.ok(loanService.updateLoan(loanDTO));
    }

    @PutMapping("/status")
    public ResponseEntity<?> updateLoanStatus(@RequestBody LoanDto loanDTO) {
        return ResponseEntity.ok(loanService.updateLoan(loanDTO));
    }
}
