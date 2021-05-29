package com.ptit.sqa.loan_management_system.service.impl;

import com.ptit.sqa.loan_management_system.entity.Customer;
import com.ptit.sqa.loan_management_system.repository.CustomerRepository;
import com.ptit.sqa.loan_management_system.service.CustomerService;
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
        return repository.findDistinctFirstByUsername(username);
    }
}
