package com.edwuin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edwuin.model.City;
import com.edwuin.model.Department;

public interface ICityRepository extends JpaRepository<City, Long> {
	List<City> findByDepartment(Department department);
}
