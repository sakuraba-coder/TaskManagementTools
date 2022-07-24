package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.model.Condition;
import com.example.demo.domain.model.Kind;
import com.example.demo.domain.model.Task;

public interface TaskService {

	List<Task> getTasks();

	Task getTask(String id);

	int insertNewTask(Task task);

	void updateTaskOne(Task task);

	void deleteTask(String id);

	List<Condition> getConditions();

	Condition getCondition(int id);

	List<Kind> getKinds();

}
