package com.manulogix.springweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manulogix.springweb.controller.Entity.Department;
import com.manulogix.springweb.errors.DepartmentNotFoundExcception;
import com.manulogix.springweb.service.DepartmentService;

import jakarta.validation.Valid;


/**
 * In this controller, get all the service(s) necessary using IOC/DependencyInjection, instead of 
 * constructor based : DepartmentService = new DepartmentService();
 */
@RestController
public class DepartmentController {

	
	/**
	 * Earlier we used to do this:
	 * DepartmentService = new DepartmentService();
	 * 
	 * Now with Autowiring , it can be invoked by Spring with IOC.
	 */
	@Autowired
	private DepartmentService deptSvc;
	
	
	/**
	 * LOGGER
	 * 
	 */
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	/**
	 * Adding a Department
	 * 
	 * @RequestBody is expecting a JSON object that should be deserialized to Department Entity. 
	 *              Earlier without SpringBoot, it used to be that you write a deserializer using Jackson 
	 *              or Json package and deserialize the request body to an Entity POJO  and pass it here. 
	 *              Now with SpringBoot, it becomes easy with a single annotation : @RequestBody
	 *    
	 * If we add a validation for say a departmentName should be NotBlank (Check Department Entity), 
	 * then add the validation here on Request Body, so 
	 * that the request is not sent over the wire.
	 * 
	 */
	@PostMapping ("/departments")
	public Department saveDepartment(@Valid @RequestBody  Department d)
	{
		/**
		 * Call the serviceLayer to save the object into Database (using the Repository
		 */
		log.info("DepartmentController.saveDepartment");
		deptSvc.saveDepartment(d);		
		return d;
	}
	
	@GetMapping("/departments")
	public List<Department> getAllDepartments()
	{
		log.info("DepartmentController.getAllDepartments");
		return deptSvc.getAllDepartments();
	}
	
	
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundExcception  
	{
		log.info("DepartmentController.getDepartmentById");
		return deptSvc.getDepartmentById(id);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long id)
	{
		log.info("DepartmentController.deleteDepartmentById");
		deptSvc.deleteDepartmentById(id);
		return ("Department deleted");
	}
	
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department dept)
	{
		log.info("DepartmentController.updateDepartment");
		return deptSvc.updateDepartmentById(id, dept);
	}
	
	
	@GetMapping("/departments/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String name)
	{
		log.info("DepartmentController.getDepartmentByName");
		return deptSvc.getDepartmentByName(name);
	}
}
