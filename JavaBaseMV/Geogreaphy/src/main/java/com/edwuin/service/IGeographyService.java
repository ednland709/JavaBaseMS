package com.edwuin.service;

import java.util.List;

import com.edwuin.model.City;
import com.edwuin.model.Department;

public interface IGeographyService {
	List<Department> getAllDepartments();
	List<City> getCitiesByDepartment(Long idDepartment);
	City getCityById(Long id);
	City createCity(City newCity);
	City updateCity(City city);
	
}
