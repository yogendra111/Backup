package com.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.entities.ToDo;

public class MyListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context Created...");
		List<ToDo> todoList = new ArrayList<ToDo>();
		ServletContext context = sce.getServletContext();
		context.setAttribute("list", todoList);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context Destroyed...");
		ServletContext context = sce.getServletContext();
		context.removeAttribute("list");;
	}

}
