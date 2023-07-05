package com.manulogix.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.manulogix.springweb.controller.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> 
{

	/**
	 * the naming convention is important :
	 * findBy<camelCase of the field> : departmentName
	 * @param name
	 * @return
	 */
	public Department findByDepartmentName(String name);
	
	/**
	 * follows a convention findBy<camelCase name of the field>IgnoreCase
	 * @param name
	 * @return
	 */
	
	/**
	 * 
	 * You can also use JPQL query for a method to execute and pass the params
	 * @Query("...").. parameters are passed as ?1, ?2 etc as parameters in the JPQL 
	 *                 if you want to pass a SQL, then add a new arg: nativeQuery = true to treat the input query as NativeSQL
	 */
	public Department findByDepartmentNameIgnoreCase(String name);
	
	
}
