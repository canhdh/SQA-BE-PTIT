package com.ptit.sqa.loan_management_system.repository;

import com.ptit.sqa.loan_management_system.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findDistinctFirstByUsername(String username);
}
