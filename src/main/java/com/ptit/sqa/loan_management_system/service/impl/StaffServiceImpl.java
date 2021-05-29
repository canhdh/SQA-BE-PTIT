package com.ptit.sqa.loan_management_system.service.impl;

import com.ptit.sqa.loan_management_system.entity.Staff;
import com.ptit.sqa.loan_management_system.repository.StaffRepository;
import com.ptit.sqa.loan_management_system.service.StaffService;
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
