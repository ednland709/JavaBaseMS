package com.edwuin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edwuin.model.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Long> {
	
}
