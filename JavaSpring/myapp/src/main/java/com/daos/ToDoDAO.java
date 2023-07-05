package com.daos;

import java.util.List;

import com.entities.ToDo;

public interface ToDoDAO {
	
	public void createToDo(ToDo t);
	public ToDo getToDo(int tid);
	public List<ToDo> getToDos();
	public void deleteToDo(int tid);
	public void updateToDo(ToDo t);

}
