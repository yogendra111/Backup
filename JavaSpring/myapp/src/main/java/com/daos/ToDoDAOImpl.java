package com.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.ToDo;

@Component
public class ToDoDAOImpl implements ToDoDAO{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	@Override
	public void createToDo(ToDo t) {
		this.hibernateTemplate.save(t);
	}
	
	@Transactional
	@Override
	public ToDo getToDo(int tid) {
		return this.hibernateTemplate.get(ToDo.class, tid);
	}

	@Transactional
	@Override
	public List<ToDo> getToDos() {
		return this.hibernateTemplate.loadAll(ToDo.class);
	}

	@Transactional
	@Override
	public void deleteToDo(int tid) {
		ToDo t = this.hibernateTemplate.load(ToDo.class, tid);
		this.hibernateTemplate.delete(t);
	}

	@Transactional
	@Override
	public void updateToDo(ToDo todo) {
//		ToDo t = this.hibernateTemplate.load(ToDo.class, tid);
		this.hibernateTemplate.update("id", todo);
	}

}
