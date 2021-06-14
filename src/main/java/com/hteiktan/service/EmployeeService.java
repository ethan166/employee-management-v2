package com.hteiktan.service;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hteiktan.dto.AddressDTO;
import com.hteiktan.dto.EmployeeDTO;
import com.hteiktan.entity.EmployeeEntity;

import net.sf.jasperreports.engine.JRException;


public interface EmployeeService {
	public void insert(EmployeeDTO emp);
	public void delete(int empId);
	public List<EmployeeDTO> getAllEmployee();
	public void updateEmpAddress(int empId, AddressDTO addressDTO);
	public List<EmployeeDTO> findByName(String name);
	public void saveAll(List<EmployeeDTO> empList);
	public Page<EmployeeEntity> findAll(Pageable requestedPage);
	public Page<EmployeeEntity> findAllBySalary(double salary, Pageable requetedPage);
	public List<Double> getListSalaries();
	public String exportReport(String reportFormat) throws JRException, FileNotFoundException; 
}
