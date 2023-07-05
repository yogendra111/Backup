package rezi.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import rezi.entities.Student;

@Repository
public class StudentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addRecord(Student stu) {
		hibernateTemplate.save(stu);
	}
	
	@Transactional
	public List<Student> getRecords() {
		return hibernateTemplate.loadAll(Student.class);
	}

	@Transactional
	public void deleteRecord(int id) {
		Student stu = hibernateTemplate.get(Student.class, id);
		hibernateTemplate.delete(stu);
	}
	
	@Transactional
	public void updateRecord(Student stu) {
		hibernateTemplate.update(stu);
	}
	
	@Transactional
	public Student getRecord(int id) {
		return hibernateTemplate.get(Student.class, id);
	}

}
