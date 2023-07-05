package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.Student;

@Controller
public class MainController {

	@RequestMapping("/form") 
	public String displayForm(Model model) { 
	    model.addAttribute("stud", new Student()); 
	    return "Registration"; 
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute Student stu, BindingResult result) {
		System.out.println("Enter " + result);
		return "Success";
	}
	
}
