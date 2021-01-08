package com.hteiktan.repository;

import java.util.List;

import com.hteiktan.dto.EmployeeDTO;

public interface EmployeeRepository {
	public void insertEmployee(EmployeeDTO emp);
	public void removeEmployee(int empId);
	public List<EmployeeDTO> fetchEmployee(); 
}
