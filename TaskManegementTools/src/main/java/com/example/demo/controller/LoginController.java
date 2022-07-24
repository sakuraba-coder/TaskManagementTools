package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.LoginForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {


	@GetMapping
	public String getLogin(@ModelAttribute LoginForm loginForm) {
		return "login/login";
	}

	@PostMapping
	public String postLogin(@ModelAttribute @Validated LoginForm loginForm, BindingResult bindingResult , Model model, RedirectAttributes redirectAttributes) {

		log.info("loginForm : " + loginForm.toString());
		if(bindingResult.hasErrors()) {
			log.error("LoginController:postLogin:エラー");
			return getLogin(loginForm);
		}

		redirectAttributes.addFlashAttribute("userName", loginForm.getName());

		return "redirect:user/list";
	}
}
