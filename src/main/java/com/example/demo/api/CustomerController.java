package com.example.demo.api;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
@RequestMapping(path = "/customer", produces = "application/json")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") int id) {
        Optional<Customer> customer = repository.findById(id);
        return customer.orElse(null);
    }

    @GetMapping("name/{username}")
    public Customer getCustomerByUserName(@PathVariable("username") String username) {
        return repository.findCustomerByUsername(username);
    }
}
