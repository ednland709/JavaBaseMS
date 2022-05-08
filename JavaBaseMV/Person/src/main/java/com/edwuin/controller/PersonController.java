package com.edwuin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edwuin.model.Person;
import com.edwuin.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@GetMapping()
	public List<Person> getAll(){
		return personService.getAllPerson();
	}
	
	@GetMapping(value="/{id}")
	public Person getById(@PathVariable("id") Long id) {
		return personService.getById(id);
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
}
