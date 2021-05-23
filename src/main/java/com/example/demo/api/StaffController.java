package com.example.demo.api;

import com.example.demo.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/staff", produces = "application/json")
@CrossOrigin(origins = "*")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getByUserName(@PathVariable("username") String username) {
        return ResponseEntity.ok(staffService.getStaffByUsername(username));
    }
}
