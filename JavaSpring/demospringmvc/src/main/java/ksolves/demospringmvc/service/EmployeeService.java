package ksolves.demospringmvc.service;

import java.util.List;

import ksolves.demospringmvc.model.EmployeeModel;

public interface EmployeeService {

	void saveEmploye(EmployeeModel employee);

	public List<EmployeeModel> emplist();

	public void deleteEmployee(Long id);
}
