package com.example.demo.api;

import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.User;

import java.util.List;

@RestController
@RequestMapping(path = "/user", produces = "application/json")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        ResponseEntity<List<User>> listUser = ResponseEntity.ok(userService.getAllUser());
        return listUser;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        ResponseEntity<User> user = ResponseEntity.ok(userService.getUserById(id));
        return user;
    }

    @GetMapping("/name/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username) {
        ResponseEntity<User> user = ResponseEntity.ok(userService.getUserByUsername(username));
        return user;
    }


}
