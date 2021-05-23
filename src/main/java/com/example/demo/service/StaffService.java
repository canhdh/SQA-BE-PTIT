package com.example.demo.service;

import com.example.demo.entities.Staff;

import java.util.Optional;

public interface StaffService {

    Optional<Staff> getStaffById(int id);

    Staff getStaffByUsername(String username);

}
