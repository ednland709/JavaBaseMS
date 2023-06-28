package com.edwuin.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edwuin.brokers.RabitMqConfig;
import com.edwuin.dto.Person;
import com.edwuin.dto.PutParams;
import com.edwuin.dto.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/pull")
public class PullDataController {
	@Autowired
    RabbitTemplate rabbitTemplate;
	
	@GetMapping()
	public ResponseEntity<List<Response>> GetList()
	{
		List<Response> elements = new ArrayList<>();
		elements.add(Response.builder().code(0).value("valor 1").build());
		elements.add(Response.builder().code(1).value("valor 2").build());
		elements.add(Response.builder().code(2).value("valor 3").build());
		
		return ResponseEntity.ok(elements);
	}
	
	@GetMapping(value="/empty")
	public ResponseEntity<List<Response>> GetEmpty()
	{
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<Response> createCity(
			@RequestBody PutParams putParams 
			) throws JsonProcessingException
	{
		Response res = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		if (putParams.getOperation() == 0) {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 1978);
			cal.set(Calendar.MONTH, Calendar.MARCH);
			cal.set(Calendar.DAY_OF_MONTH, 14);
			Date nacimi = cal.getTime();

			Person person = Person.builder()
					.birtday(nacimi)
					.email("ednland@hotmail.com")
					.idCity((long) 2)
					.identification((long)750866670)
					.lastName("edwuin")
					.name("cortes")
					.password("123")
					.build();
			
			String message = mapper.writeValueAsString(person);
	        rabbitTemplate.convertAndSend(
	        		RabitMqConfig.EXCHANGE_NAME, 
	        		RabitMqConfig.ROUTING_KEY, 
	        		message);

			res = Response.builder().code(0).value("Creacion de ciudad encolada").build();
		} else {
			res = Response.builder().code(0).value("No defined").build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value="/reduce")
	public ResponseEntity<Response> reduce(@RequestBody List<Integer> valores)
	{
		try {
			int sum = valores.stream().reduce(5, (a,b) -> a + b);
			
			Response res = Response.builder()
					.code(sum)
					.value("Sumatoria")
					.build();
			return ResponseEntity.ok(res);
		} catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.ok(Response.builder().code(-1).value(e.getMessage()).build());
		}
	}
	

}
