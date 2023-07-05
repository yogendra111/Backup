package rezi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import rezi.daos.StudentServiceImpl;
import rezi.entities.Student;

@Controller
public class MainController {

	@Autowired
	private StudentServiceImpl ss;

	@RequestMapping("/home")
	public ModelAndView start() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("students", ss.getStudents());
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("stud", new Student());
		mv.setViewName("Registration");
		return mv;
	}

	@RequestMapping(value = "/save-student", method = RequestMethod.POST)
	public ModelAndView saveData(@Valid @ModelAttribute("stud") Student stud, BindingResult result) {
		System.out.println("Result: " + result);
		
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("Registration");
		}else {
			ss.addStudent(stud);
			mv.setViewName("home");
		}
		return mv;
	}

	@RequestMapping(value = "/delete-student/{rollno}")
	public RedirectView deleteData(@PathVariable("rollno") int rollno, HttpServletRequest request) {
		ss.deleteStudent(rollno);
		return new RedirectView(request.getContextPath() + "/home");
	}

	@RequestMapping("/update/{rollno}")
	public ModelAndView update(@PathVariable("rollno") int rollNo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Update");
		mv.addObject("student", ss.getStudent(rollNo));
		return mv;
	}

	@RequestMapping(value = "/update-student", method = RequestMethod.POST)
	public RedirectView updateData(@ModelAttribute("student") Student stu, HttpServletRequest request) {
		ss.updateStudent(new Student(stu.getStuName(), stu.getCourse(), stu.getRollNo(), stu.getStuEmail()));
		return new RedirectView(request.getContextPath() + "/home");
	}

}
