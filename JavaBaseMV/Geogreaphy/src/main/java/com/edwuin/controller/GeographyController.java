package com.edwuin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edwuin.model.City;
import com.edwuin.model.Department;
import com.edwuin.service.IGeographyService;

@RestController
@RequestMapping("/geography")
public class GeographyController {
	
	@Autowired
	private IGeographyService geographyService;
	
	@GetMapping()
	public ResponseEntity<List<Department>> GetAllDepartments(
			@RequestParam (name="page", required = false, defaultValue="10") int page,
			@RequestParam (name="take", required = false, defaultValue="10") int take,
			@RequestParam (name="ids", required = false, defaultValue="") String ids)
	{
		List<Department> departments = geographyService.getAllDepartments();
		if (departments.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(departments);
	}

	@GetMapping(value="/city/{id}")
	public ResponseEntity<City> GetCityById(
			@PathVariable (name="id") Long id)
	{
		City city = geographyService.getCityById(id);
		if (city == null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(city);
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<City> createCity(
			@RequestBody City newCity 
			)
	{
		City cityCreated = geographyService.createCity(newCity);
		return ResponseEntity.status(HttpStatus.CREATED).body(cityCreated);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(value="/{id}")
	public ResponseEntity<City> updateCity(
			@PathVariable("id") Long Id,
			@RequestBody City newCity 
			)
	{
		City cityCreated = geographyService.updateCity(newCity);
		return ResponseEntity.status(HttpStatus.OK).body(cityCreated);
	}
}
