package com.ptit.sqa.loan_management_system.service.impl;

import com.ptit.sqa.loan_management_system.entity.User;
import com.ptit.sqa.loan_management_system.repository.UserRepository;
import com.ptit.sqa.loan_management_system.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return repository.findDistinctFirstByUsername(username);
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }
}
