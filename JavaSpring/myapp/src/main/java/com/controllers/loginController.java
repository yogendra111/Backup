package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {
	
//	@Autowired
//	ServletContext context;
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username") String name) {
		ModelAndView m = new ModelAndView();
		System.out.println("We are here.");
		m.addObject("username", name);
		m.setViewName("home");
		return m;
	}
	
//	@SuppressWarnings("unchecked")
//	@RequestMapping("/view")
//	public String viewToDo(Model m) {
//		m.addAttribute("page", "view");
//		m.addAttribute("todos", (List<ToDo>) context.getAttribute("list"));
//		return "home";
//	}
//
//	@RequestMapping("/add")
//	public String addToDo(Model m) {
//		ToDo t = new ToDo();
//		m.addAttribute("page", "add");
//		m.addAttribute("todo", t);
//		return "home";
//	}
//
//	@SuppressWarnings("unchecked")
//	@RequestMapping(value="/save", method=RequestMethod.POST)
//	public RedirectView saveToDo(@ModelAttribute("todo") ToDo t, Model m ) {
//		t.setDate(new Date());
//		System.out.println(t);
//		List<ToDo> list = (List<ToDo>) context.getAttribute("list");
//		list.add(t);
//		m.addAttribute("msg", "Successfully Added");
//		return new RedirectView("/myapp/view");
////		return "home";
//	}
	
}
