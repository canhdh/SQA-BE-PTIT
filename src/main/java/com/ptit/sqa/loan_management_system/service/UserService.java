package com.ptit.sqa.loan_management_system.service;

import com.ptit.sqa.loan_management_system.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(User user);
}
