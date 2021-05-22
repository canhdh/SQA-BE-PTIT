package com.example.demo.api;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        System.out.println("Customer:" + customer.getIDCustomer());
        Optional<Customer> existCustomer = repository.findById(customer.getIDCustomer());
        Customer result = existCustomer.get();
        result.setIDCustomer(existCustomer.get().getIDCustomer());
        result.setName(customer.getName());
        result.setCmnd(customer.getCmnd());
        result.setDateBorn(customer.getDateBorn());
        result.setForm(customer.getForm());
        result.setMaritalStatus(customer.getMaritalStatus());
        result.setNationality(customer.getNationality());
        result.setNumberPhone(customer.getNumberPhone());
        result.setSex(customer.getSex());
        return repository.save(result);
    }

    @GetMapping("/name/{username}")
    public Customer getCustomerByUserName(@PathVariable("username") String username) {
        return repository.findCustomerByUsername(username);
    }
}
