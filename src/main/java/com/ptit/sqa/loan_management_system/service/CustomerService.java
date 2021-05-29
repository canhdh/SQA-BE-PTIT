package com.ptit.sqa.loan_management_system.service;

import com.ptit.sqa.loan_management_system.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(int id);

    List<Customer> getAllCustomer();

    Customer updateCustomer(Customer customer);

    Customer getCustomerByUsername(String username);
}
