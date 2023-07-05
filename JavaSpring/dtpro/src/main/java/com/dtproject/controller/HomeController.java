package com.dtproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dtproject.model.User;
import com.dtproject.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/","home"})
	public String home(HttpServletRequest request) {
		System.out.println("home controller");
		
		String uName=SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(uName);
		if(!uName.equals(null) && !uName.equals("anonymousUser"))
		{
			User user=userService.findUserByName(uName);
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
		}
		
		return "home";
		
	}

}
