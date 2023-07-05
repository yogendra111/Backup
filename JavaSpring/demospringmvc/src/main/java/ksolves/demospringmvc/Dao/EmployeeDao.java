package ksolves.demospringmvc.Dao;

import java.util.List;

import ksolves.demospringmvc.entity.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee employee);
	
	List<Employee> emplist();	
	
	void deleteEmployee(Long id);

}
