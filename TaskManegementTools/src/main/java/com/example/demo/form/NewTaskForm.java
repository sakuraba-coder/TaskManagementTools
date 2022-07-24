package com.example.demo.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class NewTaskForm {

	private int kindId;
	@NotEmpty
	private String name;
}
