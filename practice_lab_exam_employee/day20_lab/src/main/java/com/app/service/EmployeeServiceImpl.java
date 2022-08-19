package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentRepository;
import com.app.dao.EmployeeRepository;
import com.app.entities.Department;
import com.app.entities.Employee;
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	//dep dao layer i/f
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public List<Employee> findByDepartment(long deptId) {
		// TODO Auto-generated method stub
		return empRepo.findByDepartment(deptId);
	}

	@Override
	public Employee addEmpDetails(Employee emp,long deptId) {
		
		//get dept by it's id
		Department dept=deptRepo.findById(deptId).orElseThrow();
		//establish uni dir many---> one
		emp.setDept(dept);
		return empRepo.save(emp);
	}//tx.commit()

	@Override
	public Employee getEmpDetails(long empId) {
		
		return empRepo.findById(empId);
	}

	@Override
	public Employee updateEmpDetails(Employee emp,long empId,long deptId) {
//     empRepo.findById(emp.getId()).orElseThrow();
		emp.setId(empId);
		Department dept=deptRepo.findById(deptId).orElseThrow();
        emp.setDept(dept);
		return empRepo.save(emp);
	}

	@Override
	public void deleteEmp(long empId) {
		
		empRepo.deleteById(empId);
	}

}
