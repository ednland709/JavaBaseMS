package com.edwuin.service;

import java.util.List;

import com.edwuin.model.Task;

public interface ITaskService {

	List<Task> getBypersonId(Long id);

	Task mergePerson(Task task);

	void deleteTask(Long id);

}