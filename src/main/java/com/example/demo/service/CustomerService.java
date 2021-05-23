package com.example.demo.service;

import com.example.demo.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(int id);

    List<Customer> getAllCustomer();

    Customer updateCustomer(Customer customer);

    Customer getCustomerByUsername(String username);
}
