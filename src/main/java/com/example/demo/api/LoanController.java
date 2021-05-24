package com.example.demo.api;

import java.util.List;

import com.example.demo.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.LoanDTO;

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
        LoanDTO customer = loanService.getLoanById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<?> getLoanByIdCustomer(@PathVariable int idCustomer) {
        List<LoanDTO> loans = loanService.getLoanByIdCustomer(idCustomer);
        return ResponseEntity.ok(loans);
    }

    @PostMapping
    public ResponseEntity<?> addLoan(@RequestBody LoanDTO loanDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(loanDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLoan(@PathVariable int id, @RequestBody LoanDTO loanDTO) {
        return ResponseEntity.ok(loanService.updateLoan(loanDTO));
    }
}
