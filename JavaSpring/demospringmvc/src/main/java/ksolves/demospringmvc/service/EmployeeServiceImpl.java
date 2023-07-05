package ksolves.demospringmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ksolves.demospringmvc.Dao.EmployeeDao;
import ksolves.demospringmvc.entity.Address;
import ksolves.demospringmvc.entity.Employee;
import ksolves.demospringmvc.model.EmployeeModel;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Value("${db}")
	String db;

	public void saveEmploye(EmployeeModel employee) {
		employeeDao.saveEmployee(convertModelToEntity(employee));
	}

	public List<EmployeeModel> emplist() {
		List<EmployeeModel> empList = new ArrayList<EmployeeModel>();
		for (Employee emp : employeeDao.emplist()) {
			empList.add(convertEntityToModel(emp, emp.getAddress()));
		}
		System.out.println(empList);
		return empList;
	}

	private EmployeeModel convertEntityToModel(Employee employee, Address address) {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setId(employee.getId());
		employeeModel.setFirstName(employee.getFirstName());
		employeeModel.setLastName(employee.getLastName());
		employeeModel.setEmail(employee.getEmail());
		employeeModel.setAdd(address.getAdd());
		return employeeModel;
	}

	private Employee convertModelToEntity(EmployeeModel employeeModel) {
		Employee employee = new Employee();
		employee.setEmail(employeeModel.getEmail());
		employee.setFirstName(employeeModel.getFirstName());
		employee.setLastName(employeeModel.getLastName());
		Address address = new Address();
		address.setAdd(employeeModel.getAdd());
		return employee;
	}

	public void deleteEmployee(Long id) {
		employeeDao.deleteEmployee(id);
	}

}
