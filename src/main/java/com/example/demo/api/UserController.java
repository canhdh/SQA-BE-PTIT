package com.example.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(path = "/user", produces = "application/json")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserRepository repository;
	
//	@Autowired
//	EntityLinks entityLinks;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public Iterable<User> findAll() {
		return repository.findAll();
	}
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") int id) {
		Optional<User> user=repository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	@GetMapping("name/{username}")
	public User checkLogin(@PathVariable("username") String username) {
		return repository.checkLogin(username);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User Register(@RequestBody User user) {
		return repository.save(user);
	}
}
