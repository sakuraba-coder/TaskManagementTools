package com.example.demo.controller;

import java.util.Calendar;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.model.Condition;
import com.example.demo.domain.model.Kind;
import com.example.demo.domain.model.Task;
import com.example.demo.form.LoginForm;
import com.example.demo.form.NewTaskForm;
import com.example.demo.form.TaskDetailForm;
import com.example.demo.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class TaskListController {

	@Autowired
	TaskService taskService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/list")
	public String getUserList(@ModelAttribute LoginForm loginForm, Model model) {

		List<Task> taskList = taskService.getTasks();

		model.addAttribute("taskList", taskList);

//		log.info(taskList.toString());

		return "user/list";
	}

	/**
	 * 登録ページ表示
	 * @return
	 */
	@GetMapping("/entry")
	public String entryNewTask(@ModelAttribute NewTaskForm newTaskForm, Model model) {

		List<Kind> kindList = taskService.getKinds();
		model.addAttribute("kindList", kindList);

		return "user/entry";
	}

	@PostMapping(value="/list", params="insert")
	public String insertNewTask(@ModelAttribute @Validated NewTaskForm newTaskForm , BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors()) {
			log.error("insertNewTaskエラー！");
			return entryNewTask(newTaskForm, model);
//			return "user/entry";
		}

		Task task = modelMapper.map(newTaskForm, Task.class);
		task.setEntryDate(Calendar.getInstance().getTime());
		task.setConditionId(2);

		try {
			taskService.insertNewTask(task);
		}catch (Exception e) {
			log.error("タスク登録でエラー", e);
		}

		return "redirect:/user/list";
	}




	/**
	 * 更新処理
	 * todo
	 * @param loginForm
	 * @param model
	 * @return
	 */
	@PostMapping(value="/list", params="update")
	public String updateTaskList(@ModelAttribute @Validated TaskDetailForm taskDetailForm, BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors()) {
			log.error("updateTaskListエラー！");
			return "user/detail";
		}

		Task task = modelMapper.map(taskDetailForm, Task.class);
		task.setCondition(taskService.getCondition(taskDetailForm.getConditionId()));

		log.info("taskのログ：" + task.toString());

		try {
			taskService.updateTaskOne(task);
		} catch (Exception e) {
			log.error("タスク更新でエラー", e);
		}

		return "redirect:/user/list";
	}


	@PostMapping(value="/list", params="delete")
	public String deleteTask(@ModelAttribute TaskDetailForm taskDetailForm, Model model) {

		try {
			taskService.deleteTask(String.valueOf(taskDetailForm.getId()));
		} catch (Exception e) {
			log.error("タスク削除でエラー", e);
		}

		return "redirect:/user/list";
	}

	/**
	 *
	 * @param taskDetailForm
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/detail/{id}")
	public String getTaskListDetail(TaskDetailForm taskDetailForm, Model model, @PathVariable("id") String id) {

		Task task = taskService.getTask(id);

		taskDetailForm = modelMapper.map(task, TaskDetailForm.class);
		model.addAttribute("taskDetailForm", taskDetailForm);

		List<Condition> conditionList = taskService.getConditions();
		model.addAttribute("conditionList", conditionList);


		log.info(task.toString());

		return "user/detail";
	}


}
