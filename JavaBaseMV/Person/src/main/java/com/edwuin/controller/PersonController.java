package com.edwuin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edwuin.feignclients.IGeographyClient;
import com.edwuin.model.City;
import com.edwuin.model.Person;
import com.edwuin.service.PersonService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	@Autowired
	private IGeographyClient geographyclient;
	
	@GetMapping()
	public ResponseEntity<List<Person>> getAll(){
		List<Person> persons = personService.getAllPerson();
		if (persons.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(persons);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Person> getById(@PathVariable("id") Long id) {
		Person person = personService.getById(id);
		person.setCity(getCityById(person.getIdCity()));
		
		if (person == 	null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(person);
	}
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		return personService.mergePerson(person);
	}
	@PutMapping(value="/{id}")
	public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
		person.setId(id);
		return personService.mergePerson(person);
	}
	@DeleteMapping(value="/{id}")
	public void deletePerson(@PathVariable("id") Long id) {
		personService.deletePerson(id);
	}
	
	@CircuitBreaker(name = "myInstance", fallbackMethod = "fallbackCity")
	private City getCityById(Long id) {
		return geographyclient.GetCityById(id);
	}
	
	private City fallbackCity() {
		return null;
	}
}
