package com.example.demo.service.impl;

import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer getCustomerById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return (List<Customer>) repository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer result = repository.save(customer);
        return result;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return repository.findCustomerByUsername(username);
    }
}
