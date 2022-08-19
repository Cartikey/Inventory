package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentRepository;
import com.app.entities.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
	// dep : dao layer i/f
	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public List<Department> getAllDepartments() {
		return deptRepo.findAll();
	}

}
