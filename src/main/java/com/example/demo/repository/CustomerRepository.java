package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findCustomerByUsername(String username);
}
