package com.edwuin.brokers;

import org.springframework.beans.factory.annotation.Autowired;

import com.edwuin.model.Person;
import com.edwuin.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateUserBroker {

	@Autowired
	PersonService personaService;
	
	public static final String RECEIVE_METHOD_NAME = "receiveMessage";
	 
    public void receiveMessage(String message) throws JsonMappingException, JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	Person person = mapper.readValue(message, Person.class);
    	personaService.mergePerson(person);
    }
}
