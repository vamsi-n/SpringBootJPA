package com.manulogix.springweb.service;

import java.util.List;

import com.manulogix.springweb.controller.Entity.Department;
import com.manulogix.springweb.errors.DepartmentNotFoundExcception;

public interface DepartmentService {

	public Department saveDepartment(Department d);
	
	public List<Department> getAllDepartments();

	public Department getDepartmentById(Long id) throws DepartmentNotFoundExcception;
	
	public void deleteDepartmentById(Long id);
	
	public Department updateDepartmentById(Long id, Department d);
	
	public Department getDepartmentByName(String name);

}
