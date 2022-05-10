package com.edwuin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edwuin.model.Task;
import com.edwuin.repository.TasksRepository;

@Service
public class TasksService implements ITaskService {
	@Autowired
	private TasksRepository taskRepository;
	
	@Override
	public List<Task> getBypersonId(Long id) {
		return taskRepository.findByUserId(id);
	}
	
	@Override
	public Task mergePerson (Task task) {
		return taskRepository.save(task);
	}
	
	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

}
