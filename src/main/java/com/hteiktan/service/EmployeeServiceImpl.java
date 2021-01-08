package com.hteiktan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hteiktan.dto.EmployeeDTO;
import com.hteiktan.repository.EmployeeRepository;
import com.hteiktan.repository.EmployeeRepositoryImpl;

@Service("employeeService")
@Scope("prototype")
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeDAO;
	
	
	public void insert(EmployeeDTO emp) {
		employeeDAO.insertEmployee(emp);
	}

	public void delete(int empId) {
		employeeDAO.removeEmployee(empId);
	}

	public List<EmployeeDTO> getAllEmployee() {
		return employeeDAO.fetchEmployee();
	}
	

}
