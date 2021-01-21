package com.hteiktan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hteiktan.dto.AddressDTO;
import com.hteiktan.dto.EmployeeDTO;
import com.hteiktan.entity.AddressEntity;
import com.hteiktan.entity.EmployeeEntity;
import com.hteiktan.repository.EmployeeRepository;


@Service("employeeService")
@Scope("prototype")
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeDAO;
	
	@Override
	public void insert(EmployeeDTO emp) {
		employeeDAO.saveAndFlush(EmployeeDTO.prepareEmployeeEntity(emp));
		//employeeDAO.insertEmployee(EmployeeDTO.prepareEmployeeEntity(emp));
	}
	@Override
	public void delete(int empId) {
		//employeeDAO.removeEmployee(empId);
		employeeDAO.deleteById(empId);
	}
 	public List<EmployeeDTO> getAllEmployee() {
		List<EmployeeDTO> empList = new ArrayList<>();
		List<EmployeeEntity> empEntityList = employeeDAO.findAll();
		//List<EmployeeEntity> empEntityList = employeeDAO.fetchEmployee();
		for(EmployeeEntity empEntity: empEntityList) {
			EmployeeDTO empDTO = EmployeeEntity.prepareEmployeeDTO(empEntity);
			empList.add(empDTO  );
		}
		return empList;
	}
	@Override
	public void updateEmpAddress(int empId, AddressDTO addressDTO) {
		Optional<EmployeeEntity> optionalEmployee = employeeDAO.findById(empId);
		EmployeeEntity employeeEntity = optionalEmployee.get();
		employeeEntity.setAddress(AddressDTO.prepareAddressEntity(addressDTO));
		employeeDAO.save(employeeEntity);
		//employeeDAO.update(empId, AddressDTO.prepareAddressEntity(addressDTO));
	}
		
		 
	
	
	

}
