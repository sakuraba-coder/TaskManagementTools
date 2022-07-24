package com.example.demo.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginForm {

	@NotEmpty
//	@Length(min = 4,max = 100)
	private String name;

	@NotEmpty
//	@Length(min = 4,max = 100)
	private String password;
}
