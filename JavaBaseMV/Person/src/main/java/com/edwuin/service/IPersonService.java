package com.edwuin.service;

import java.util.List;

import com.edwuin.model.Person;

public interface IPersonService {

	List<Person> getAllPerson();

	Person getById(Long id);

	Person mergePerson(Person person);

	void deletePerson(Long id);

}