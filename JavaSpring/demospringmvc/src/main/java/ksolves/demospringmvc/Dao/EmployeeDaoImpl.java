package ksolves.demospringmvc.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksolves.demospringmvc.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessfactory;

	public void saveEmployee(Employee employee) {
		Session session = sessfactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();

	}

//	public EmployeeModel findUserEmployeeByname(String employeeName) {
//		Session session = sessfactory.openSession();
//		List<Employee> data = session.createQuery("select * From Employee", Employee.class).getResultList();
//		
//		return employee;
//	}

	public List<Employee> emplist() {
		Session session = sessfactory.openSession();
		List<Employee> data = session.createNativeQuery("select * from Employee", Employee.class).getResultList();
		return data;
	}

	public void deleteEmployee(Long id) {
		Session session = sessfactory.openSession();
		session.beginTransaction();
		Employee employee = new Employee();
		employee.setId(id);
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}

}
