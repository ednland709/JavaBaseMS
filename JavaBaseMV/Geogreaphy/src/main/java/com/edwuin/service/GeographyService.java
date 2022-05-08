package com.edwuin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edwuin.model.City;
import com.edwuin.model.Department;
import com.edwuin.repository.ICityRepository;
import com.edwuin.repository.IDepartmentRepository;

@Service
public class GeographyService implements IGeographyService {
	//@Autowired
	private ICityRepository cityRepository;
	
	@Autowired
	private IDepartmentRepository departmentRepository;
	
	
	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public List<City> getCitiesByDepartment(Long idDepartment) {
		var department = departmentRepository.findById(idDepartment).orElse(null);
		return cityRepository.findByDepartment(department);
	}
	
	@Override
	public City getCityById(Long id) {
		return cityRepository.findById(id).orElse(null);
	}

	@Override
	public City createCity(City newCity) {
		return cityRepository.save(newCity);
	}
	
	@Override
	public City updateCity(City city) {
		//City citydb = cityRepository.findById(city.getId()).orElse(null);
		//citydb.setName(city.getName());
		return cityRepository.save(city);
	}
	
	
}