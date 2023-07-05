package com.manulogix.springweb.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manulogix.springweb.controller.Entity.Department;
import com.manulogix.springweb.errors.DepartmentNotFoundExcception;
import com.manulogix.springweb.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository deptRepository;
	
	@Override
	public Department saveDepartment(Department d) {
	
		return deptRepository.save(d);
		
	}

	@Override
	public List<Department> getAllDepartments() 
	{
		return deptRepository.findAll();
	}
	


	/**
	 * TO NOT USE OPTIONAL
	 */
//	public Department getDepartmentById(Long id) {
//		
//		return deptRepository.findById(id).get();
//	}
	
	@Override
	public Department getDepartmentById(Long id) throws DepartmentNotFoundExcception
	{
		Optional<Department> dept = deptRepository.findById(id);
		
		if ( !dept.isPresent() )
			throw new DepartmentNotFoundExcception("Department with ID < "+ id + " > not found");
		return dept.get();
			
	}

	
	@Override
	public void deleteDepartmentById(Long id) {
		
		 deptRepository.deleteById(id);
	}
	
	@Override
	public Department updateDepartmentById(Long id, Department d) {
		
		 Department cur = deptRepository.findById(id).get();
		 if ( cur == null )
			 return new Department();
		 
		 // If name is not null and not empty.. then update the name
		 if (Objects.nonNull(d.getDepartmentName()) && !"".equalsIgnoreCase(d.getDepartmentName()) )
		 {
			 cur.setDepartmentName(d.getDepartmentName());
		 }
		 
		 if (Objects.nonNull(d.getDepartmentAddress()) && !"".equalsIgnoreCase(d.getDepartmentAddress()) )
		 {
			 cur.setDepartmentAddress(d.getDepartmentAddress());
		 }
		 if (Objects.nonNull(d.getDepartmentCode()) && !"".equalsIgnoreCase(d.getDepartmentCode()) )
		 {
			 cur.setDepartmentCode(d.getDepartmentCode());
		 }
		 
		 return deptRepository.save(cur);
		 
	}

	/**
	 * There are two ways of setting this up: with either 
	 * findByDepartmentNameIgnoreCase or 
	 * findByDepartmentName
	 */
	@Override
	public Department getDepartmentByName(String name) {
		return deptRepository.findByDepartmentNameIgnoreCase(name);
	}
	
}
