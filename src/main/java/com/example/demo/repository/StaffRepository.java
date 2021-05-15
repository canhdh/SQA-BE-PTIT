package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer>{
	@Query(value = "SELECT t FROM Staff t WHERE username = ?1" )
	public Staff getByUserName(@Param("username") String username);
}
