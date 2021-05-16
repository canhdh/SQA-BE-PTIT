package com.example.demo.api;

import java.util.Optional;

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
    private final StaffRepository repository;

    public StaffController(StaffRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Staff> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Staff findById(@PathVariable("id") int id) {
        Optional<Staff> customer = repository.findById(id);
        return customer.orElse(null);
    }

    @GetMapping("name/{username}")
    public Staff getByUserName(@PathVariable("username") String username) {
        return repository.findStaffByUsername(username);
    }
}
