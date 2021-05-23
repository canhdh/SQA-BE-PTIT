package com.example.demo.service;

import com.example.demo.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(User user);
}
