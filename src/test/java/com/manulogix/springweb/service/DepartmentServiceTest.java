package com.manulogix.springweb.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.manulogix.springweb.controller.Entity.Department;
import com.manulogix.springweb.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService deptSvc;
	
	@MockBean
	private DepartmentRepository repo;
	
	@BeforeEach
	void setup()
	{
		Department d = Department.builder().departmentName("Claims").
				departmentAddress("WashingtonDC").departmentCode("CLM-1").departmentId(1L).build();
		Mockito.when(repo.findByDepartmentName("Claims")).thenReturn(d);
				
	}


	/**
	 * This test case is for testing the SERVICE_LAYER and not REPOSITORY LAYER
	 * So mock the repository Layer but test the service layer is funcitoning fine.
	 */
	@Test
	@Disabled
	void testFindByDepartmentName() {
		String deptName = "Claims";
		Department d = deptSvc.getDepartmentByName(deptName);
		assertEquals(deptName, d.getDepartmentName());
	}

}
