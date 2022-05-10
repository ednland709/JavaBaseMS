package com.edwuin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edwuin.model.Task;
import com.edwuin.service.ITaskService;


@RestController
@RequestMapping("/tasks")
public class TasksController {
	@Autowired
	private ITaskService tasksService;
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<Task> createCity(
			@RequestBody Task newCity 
			)
	{
		Task cityCreated = tasksService.mergePerson(newCity);
		return ResponseEntity.status(HttpStatus.CREATED).body(cityCreated);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<List<Task>> GetAllDepartments(
			@PathVariable (name="id") Long id)
	{
		List<Task> tasks = tasksService.getBypersonId(id);
		if (tasks.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(tasks);
	}

	
}
