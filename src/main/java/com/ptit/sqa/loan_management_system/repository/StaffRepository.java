package com.ptit.sqa.loan_management_system.repository;

import com.ptit.sqa.loan_management_system.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
	Staff findStaffByUsername(String username);
}
