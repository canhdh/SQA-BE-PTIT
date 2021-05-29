package com.ptit.sqa.loan_management_system.rest;

import com.ptit.sqa.loan_management_system.service.CustomerService;
import com.ptit.sqa.loan_management_system.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customer", produces = "application/json")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") int id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        Customer existCustomer = customerService.getCustomerById(customer.getId());
        customer.setUsername(existCustomer.getUsername());
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getCustomerByUserName(@PathVariable("username") String username) {
        return ResponseEntity.ok(customerService.getCustomerByUsername(username));
    }
}
