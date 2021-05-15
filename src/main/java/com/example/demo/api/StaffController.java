package com.example.demo.api;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Staff;
import com.example.demo.repository.StaffRepository;

@RestController
@RequestMapping(path = "/staff", produces = "application/json")
@CrossOrigin(origins = "*")
public class StaffController {
	@Autowired
	private StaffRepository repository;
	
	public StaffController(StaffRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public Iterable<Staff> findAll() {
		return repository.findAll();
	}
	@GetMapping("/{id}")
	public Staff findById(@PathVariable("id") int id) {
		Optional<Staff> customer=repository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
		return null;
	}
	@GetMapping("name/{username}")
	public Staff getByUserName(@PathVariable("username") String username) {
		return repository.getByUserName(username);
	}
}
