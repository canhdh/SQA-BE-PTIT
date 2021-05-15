package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Customer;
import com.example.demo.entities.User;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	@Query(value = "SELECT t FROM Customer t WHERE username = ?1" )
	public Customer getByUserName(@Param("username") String username);
}
