package com.ptit.sqa.loan_management_system.repository;

import com.ptit.sqa.loan_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findDistinctFirstByUsername(String username);
}
