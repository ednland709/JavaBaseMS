package com.edwuin.cron;

import java.util.Calendar;
import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.edwuin.brokers.RabitMqConfig;
import com.edwuin.dto.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CronPersona {
	@Autowired
    RabbitTemplate rabbitTemplate;
	
	//@Scheduled(cron = "* * * * * *")
	public void CrearPersona() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("Creando persona");
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

	}
}
