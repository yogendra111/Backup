package com.dtproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dtproject.model.Product;
import com.dtproject.model.User;
import com.dtproject.service.ProductService;
import com.dtproject.service.UserService;

@Controller
public class UserController 
{
	
	@Autowired
	UserService userService;
	
	@Autowired
	private ProductService productService;
	
  @RequestMapping("/registerUser")
  public ModelAndView registerUser()
  {
	  ModelAndView mv=new ModelAndView();
	  User user=new User();
	  mv.addObject("user",user);
	  mv.setViewName("register");
	  return mv;
	  
  }
  
  @RequestMapping(value="/saveUser",method=RequestMethod.POST)
  public String saveUser(@ModelAttribute("user") User user,@RequestParam("uPic") MultipartFile mfile)
  {
	 
	 System.out.println(user.getuName());
		
		String filename=mfile.getOriginalFilename();
		String rootPath="E:\\updatedProject\\dtpro\\src\\main\\webapp\\WEB-INF\\Resources\\userPic";
		
		if(!mfile.isEmpty())
		{
			try {
				byte b[]=mfile.getBytes();
				File f=new File(rootPath+File.separator+filename);
				
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(b);
				bos.close();
				fos.close();
				System.out.println("File image saved successfully");
				user.setuImg(filename);
			}
			catch(Exception e) {
				System.out.println("Exception: "+e);	
			}
		}
		userService.saveUser(user); 
	return "redirect:/home";
  }
  
  @RequestMapping("/{uName}/userProfile")
  public ModelAndView user(@PathVariable("uName") String uName)
  {
	  User user=userService.findUserByName(uName);
	  ModelAndView mv=new ModelAndView();
	  mv.addObject("user",user);
	  mv.setViewName("userProfile");
	return mv;
	  
  }
  
  @RequestMapping("/login")
public ModelAndView login(@RequestParam(value="error",required=false)String error,
			@RequestParam(value="logout",required=false)String logout) {
		ModelAndView mv = new ModelAndView();
		if(error!=null)
			mv.addObject("error", "Invalid UserName or password... please enter valid username or password");
		
		if(logout!=null)
			mv.addObject("logout", "Logged Out Successfully");
		
		mv.setViewName("login");
		return mv;
	}
  
  @RequestMapping("/viewProduct/{pId}")
  public ModelAndView viewproduct(@PathVariable("pId") int productId)
  {
	  ModelAndView mv=new ModelAndView();
	  Product product=productService.findProductById(productId);
	  mv.addObject("product", product);
	  mv.setViewName("showProduct");
	return mv;
	  
  }
}
