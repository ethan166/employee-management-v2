package com.hteiktan.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hteiktan.dto.EmployeeDTO;

@Repository("employeeRepository")
@Scope("singleton")
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	List<EmployeeDTO> employee = null;
	
	@PostConstruct
	public void initializer() {
		// where we connect to database
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(101);
		employeeDTO.setEmpName("Jack");
		employeeDTO.setDepartment("ETA");
		employee = new ArrayList<EmployeeDTO>();
		employee.add(employeeDTO);
	}
	
	public void insertEmployee(EmployeeDTO emp) {
		employee.add(emp);
	}
	
	public void removeEmployee(int empId) {
		employee.remove(empId);
	}


	public List<EmployeeDTO> fetchEmployee() {
		// TODO Auto-generated method stub
		return employee;
	}
}

