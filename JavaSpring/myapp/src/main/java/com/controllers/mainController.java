package com.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.daos.ToDoDAO;
import com.entities.ToDo;

@Controller
public class mainController {
	
	@Autowired
	private ToDoDAO todoDao;
	
	@RequestMapping("/add-todo")
	public String addToDo(Model m) {
		m.addAttribute("page", "addToDo");
		return "home";
	}
	
	@RequestMapping("/view-todo")
	public String viewToDo(Model m) {
		List<ToDo> todos = todoDao.getToDos();
		m.addAttribute("todos", todos);
		m.addAttribute("page", "viewToDo");
		return "home";
	}
	
	@RequestMapping(value="/save-todo", method = RequestMethod.POST)
	public RedirectView saveToDo(@ModelAttribute("todo") ToDo t, HttpServletRequest request) {
		t.setDate(new Date());
		System.out.println("++++"+t);
		todoDao.createToDo(t);
		return new RedirectView(request.getContextPath() + "/view-todo");
	}
	
	@RequestMapping(value="/delete-todo/{todoId}")
	public RedirectView deleteToDo(@PathVariable("todoId") int tid,HttpServletRequest request) {
		todoDao.deleteToDo(tid);
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/view-todo");
		return redirectview;
	}
	
	@RequestMapping("/update/{todoId}")
	public ModelAndView updateTodo(@PathVariable("todoId") int tid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("todo", todoDao.getToDo(tid));
		mv.setViewName("update");
		return mv;
	}
	
	@RequestMapping("/update-todo/{todoId}")
	public RedirectView update(@PathVariable("todoId") int tid,@ModelAttribute("todo") ToDo t, HttpServletRequest request) {
		t.setId(tid);
		t.setDate(new Date());
		todoDao.updateToDo(t);
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/view-todo");
		return redirectview;
	}

}
