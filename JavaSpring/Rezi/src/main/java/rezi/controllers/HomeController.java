package rezi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

   @RequestMapping(value="/admin")  
   public String admin() {
       return "Admin";  
   }
   
   @RequestMapping("/login")
   public ModelAndView login(@RequestParam(value="error",required=false)String error,
   			@RequestParam(value="logout",required=false)String logout) {
   		ModelAndView mv = new ModelAndView();
   		if(error!=null)
   			mv.addObject("error", "Invalid UserName or password.");
   		
   		if(logout!=null)
   			mv.addObject("logout", "Logged Out Successfully");
   		
   		mv.setViewName("login");
   		return mv;
   	}
	
}
