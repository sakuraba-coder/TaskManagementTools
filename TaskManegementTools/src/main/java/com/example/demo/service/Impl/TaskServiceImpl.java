package com.example.demo.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.model.Condition;
import com.example.demo.domain.model.Kind;
import com.example.demo.domain.model.Task;
import com.example.demo.repository.TaskMapper;
import com.example.demo.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
//	TaskRepository taskRepository;
	TaskMapper taskMapper;

	@Override
	public List<Task> getTasks() {
//		return taskRepository.findAll();
		return taskMapper.findAll();
	}

	@Override
	public Task getTask(String id) {
//		return taskRepository.find(id);
		return taskMapper.find(id);
	}

	@Override
	public int insertNewTask(Task task) {

		return taskMapper.insert(task);
	}

	@Override
	public void updateTaskOne(Task task) {
		log.info("TaskServiceImpl:updateTaskOne:"+task);
		taskMapper.update(task);
		task.setCompleteDate(new Date());
		taskMapper.insertLog(task);
	}

	@Override
	public void deleteTask(String id) {
		taskMapper.delete(id);
	}


	@Override
	public List<Condition> getConditions() {
		return taskMapper.getConditions();
	}

	@Override
	public List<Kind> getKinds() {
		return taskMapper.getKinds();
	}

	@Override
	public Condition getCondition(int id) {
		return taskMapper.getCondition(id);
	}


}
