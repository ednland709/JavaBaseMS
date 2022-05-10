package com.edwuin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edwuin.model.Task;


@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {
	public List<Task> findByUserId(Long id);
}
