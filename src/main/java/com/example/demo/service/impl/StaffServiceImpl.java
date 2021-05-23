package com.example.demo.service.impl;

import com.example.demo.entities.Staff;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository repository;

    public StaffServiceImpl(StaffRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Staff> getStaffById(int id) {
        return repository.findById(id);
    }

    @Override
    public Staff getStaffByUsername(String username) {
        return repository.findStaffByUsername(username);
    }
}
