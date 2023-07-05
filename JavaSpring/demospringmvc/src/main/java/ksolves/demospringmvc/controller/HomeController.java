package ksolves.demospringmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ksolves.demospringmvc.model.EmployeeModel;
import ksolves.demospringmvc.service.EmployeeServiceImpl;

@Controller
public class HomeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveRepo(@Valid @ModelAttribute("emp1") EmployeeModel employee, BindingResult result) throws IOException {
		if(result.hasErrors()) {
			return new ModelAndView("register");
		}
		employeeServiceImpl.saveEmploye(employee);
		return new ModelAndView("savesuccess");
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView test2(HttpServletResponse response) throws IOException {
		EmployeeModel emp = new EmployeeModel();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		mv.addObject("emp1", emp);
		return mv;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		mv.addObject("listEmployees", employeeServiceImpl.emplist());
		return mv;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable(name = "id") Long id) {
		employeeServiceImpl.deleteEmployee(id);
		return "redirect:/all";
	}

}
