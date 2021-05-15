package com.example.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Customer;
import com.example.demo.entities.User;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(path = "/customer", produces = "application/json")
@CrossOrigin(origins = "*")
public class CustomerController {
	@Autowired
	private CustomerRepository repository;
	
	public CustomerController(CustomerRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public Iterable<Customer> findAll() {
		return repository.findAll();
	}
	@GetMapping("/{id}")
	public Customer findById(@PathVariable("id") int id) {
		Optional<Customer> customer=repository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
		return null;
	}
	@GetMapping("name/{username}")
	public Customer getByUserName(@PathVariable("username") String username) {
		return repository.getByUserName(username);
	}
}
