package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String username;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String birthday;
    @Column
    private String address;
    @Column
    private String gender;
    @Column
    private String phoneNumber;
    @Column
    private String idCard;
    @Column
    private String nationality;
    @Column
    private String maritalStatus;
}