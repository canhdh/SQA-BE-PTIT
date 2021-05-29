package com.ptit.sqa.loan_management_system.service;

import com.ptit.sqa.loan_management_system.entity.Staff;

import java.util.Optional;

public interface StaffService {

    Optional<Staff> getStaffById(int id);

    Staff getStaffByUsername(String username);

}
