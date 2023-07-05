package com.daos;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entities.ToDo;

@Repository
public class Dao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void save(ToDo t) 
	{  
		hibernateTemplate.save(t);
	}
	
	

}
