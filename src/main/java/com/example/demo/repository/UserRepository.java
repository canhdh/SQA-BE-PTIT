package com.example.demo.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	@Query(value = "SELECT t FROM User t WHERE username = ?1" )
	public User checkLogin(@Param("username") String username);
}
