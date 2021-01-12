package com.hteiktan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hteiktan.dto.AddressDTO;
import com.hteiktan.dto.EmployeeDTO;
import com.hteiktan.entity.AddressEntity;
import com.hteiktan.entity.EmployeeEntity;
import com.hteiktan.repository.EmployeeRepository;
import com.hteiktan.repository.EmployeeRepositoryImpl;

@Service("employeeService")
@Scope("prototype")
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeDAO;
	
	@Override
	public void insert(EmployeeDTO emp) {
		
		employeeDAO.insertEmployee(EmployeeDTO.prepareEmployeeEntity(emp));
	}
	@Override
	public int delete(int empId) {
		return employeeDAO.removeEmployee(empId);
	}
	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<EmployeeDTO> empList = new ArrayList<>();
		List<EmployeeEntity> empEntityList = employeeDAO.fetchEmployee();
		for(EmployeeEntity empEntity: empEntityList) {
			EmployeeDTO empDTO = EmployeeEntity.prepareEmployeeDTO(empEntity);
			empList.add(empDTO);
		}
		return empList;
	}
	@Override
	public void updateEmpAddress(int empId, AddressDTO addressDTO) {
		employeeDAO.update(empId, AddressDTO.prepareAddressEntity(addressDTO));
	}
		
		 
	
	
	

}
