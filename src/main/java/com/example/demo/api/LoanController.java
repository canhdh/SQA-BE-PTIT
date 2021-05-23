package com.example.demo.api;

import java.util.List;

import com.example.demo.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Loan;

@RestController
@RequestMapping(path = "/loan", produces = "application/json")
@CrossOrigin(origins = "*")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    public ResponseEntity<?> getAllLoan() {
        return ResponseEntity.ok(loanService.getAllLoan());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        Loan customer = loanService.getLoanById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<?> getLoanByIdCustomer(@PathVariable int idCustomer) {
        List<Loan> loans = loanService.getLoanByIdCustomer(idCustomer);
        return ResponseEntity.ok(loans);
    }

    @PostMapping
    public ResponseEntity<?> addLoan(@RequestBody Loan loan) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(loan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLoan(@PathVariable int id, @RequestBody Loan loan) {
        return ResponseEntity.ok(loanService.updateLoan(loan));
    }
}
