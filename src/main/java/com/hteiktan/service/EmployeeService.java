package com.hteiktan.service;
import java.util.List;

import com.hteiktan.dto.AddressDTO;
import com.hteiktan.dto.EmployeeDTO;


public interface EmployeeService {
	public void insert(EmployeeDTO emp);
	public void delete(int empId);
	public List<EmployeeDTO> getAllEmployee();
	public void updateEmpAddress(int empId, AddressDTO addressDTO);
	public List<EmployeeDTO> findByName(String name);
}
