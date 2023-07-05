package fileUp.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fileUp.entities.User;

@Controller
public class UserController {
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("validateform");
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@Valid @ModelAttribute("user") User user, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		System.out.println("result : " + result);
//		System.out.println("result : " + user.getName());
//		System.out.println("result : " + user.getEmail());
//		System.out.println("result : " + user.getPassword());
		
		if(result.hasErrors()) {
			mv.setViewName("validateform");
		}else {
			mv.setViewName("success");
		}
		
		return mv;
	}

}
