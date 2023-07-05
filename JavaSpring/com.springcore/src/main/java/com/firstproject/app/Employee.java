package com.firstproject.app;

import java.util.List;

class Employee{
	int empId;
	String empName;
	List<String> address;

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + "]";
	}
	
//	public Employee(int empId, String empName, List<String> address) {
//		super();
//		this.empId = empId;
//		this.empName = empName;
//		this.address = address;
//	}
}