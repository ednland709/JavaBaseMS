package com.edwuin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edwuin.model.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {
	
}
