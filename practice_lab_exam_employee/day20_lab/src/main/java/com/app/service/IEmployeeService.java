package com.app.service;

import java.util.List;

import com.app.entities.Employee;

public interface IEmployeeService {
//add a method to get list of emsp from a specific dept id
	List<Employee> findByDepartment(long deptId);
	//add new emp details
	Employee addEmpDetails(Employee emp,long deptId);
	Employee getEmpDetails(long empId);
	Employee updateEmpDetails(Employee emp,long empId,long deptId);
	void deleteEmp(long empId);
}
