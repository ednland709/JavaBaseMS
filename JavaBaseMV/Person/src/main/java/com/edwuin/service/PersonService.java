package com.edwuin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edwuin.model.Person;
import com.edwuin.repository.PersonRepository;

@Service
public class PersonService implements IPersonService {
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}
	
	@Override
	public Person getById(Long id) {
		return personRepository.findById(id).orElse(null);
	}
	
	
	@Override
	public Person mergePerson (Person person) {
		return personRepository.save(person);
		/*
		Person persondb = personRepository.getById(person.getId());
		if (persondb == null) {
			return personRepository.save(person);
		}
		else {
			persondb.setEmail(person.getEmail());
			persondb.setIdentification(person.getIdentification());
			persondb.setBirtday(person.getBirtday());
			persondb.setIdCity(person.getIdCity());
			persondb.setName(person.getName());
			persondb.setLastName(person.getLastName());
			return personRepository.save(persondb);
		}*/
	}
	
	@Override
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
}
