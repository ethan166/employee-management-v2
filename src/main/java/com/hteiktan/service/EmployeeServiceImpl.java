package com.hteiktan.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.hteiktan.dto.AddressDTO;
import com.hteiktan.dto.EmployeeDTO;
import com.hteiktan.entity.AddressEntity;
import com.hteiktan.entity.EmployeeEntity;
import com.hteiktan.repository.EmployeeRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service("employeeService")
@Scope("prototype")
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeDAO;
	
	@Override
	public void insert(EmployeeDTO emp) {
		employeeDAO.save(EmployeeDTO.prepareEmployeeEntity(emp));
		//employeeDAO.saveAndFlush(EmployeeDTO.prepareEmployeeEntity(emp));
		//employeeDAO.insertEmployee(EmployeeDTO.prepareEmployeeEntity(emp));
	}
	@Override
	public void saveAll(List<EmployeeDTO> empDTOList) {
		List<EmployeeEntity> empEntityList = new ArrayList<>();
		
		//DTO list to entityList
		for(EmployeeDTO empDTO: empDTOList) {
			empEntityList.add(EmployeeDTO.prepareEmployeeEntity(empDTO));
		}
		
		employeeDAO.saveAll(empEntityList);
	}
	
	@Override
	public void delete(int empId) {
		//employeeDAO.removeEmployee(empId);
		employeeDAO.deleteById(empId);
	}
 	public List<EmployeeDTO> getAllEmployee() {
		List<EmployeeDTO> empList = new ArrayList<>();
		List<EmployeeEntity> empEntityList = (List<EmployeeEntity>) employeeDAO.findAll();
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
	@Override
	public List<EmployeeDTO> findByName(String name) {
		List<EmployeeDTO> empList = new ArrayList<>();
		List<EmployeeEntity> empEntityList = employeeDAO.findByfirstname(name);
		//List<EmployeeEntity> empEntityList = employeeDAO.fetchEmployee();
		for(EmployeeEntity empEntity: empEntityList) {
			EmployeeDTO empDTO = EmployeeEntity.prepareEmployeeDTO(empEntity);
			empList.add(empDTO);
		}
		return empList;
	}
	@Override
	public Page<EmployeeEntity> findAll(Pageable requestedPage) {
		return this.employeeDAO.findAll(requestedPage);
	
	}
	@Override
	public Page<EmployeeEntity> findAllBySalary(double salary, Pageable requetedPage) {
		
		return this.employeeDAO.findAllBySalary(salary, requetedPage);
	}
	
	@Override
	public List<Double> getListSalaries() {
		
		return this.employeeDAO.findDistincySalary();
	}
	@Override
	public String exportReport(String reportFormat) throws JRException, FileNotFoundException {
		List<EmployeeEntity> employees = (List<EmployeeEntity>) employeeDAO.findAll();
		String path = "/Users/Ethan/Downloads";
		//load file and compile it
			File file = ResourceUtils.getFile("classpath:employees.jrxml");
			JasperReport jasperReport =  JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("createdBy", "Ethan");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			if(reportFormat.equalsIgnoreCase("html")) {
				JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/employees.html");
			}
			if(reportFormat.equalsIgnoreCase("pdf")) {
				JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/employees.pdf");
			}
			return "report generated in path: " + path;
	}
	
//	Pageable requestedPage = PageRequest.of(0, 5);
//	Page<Customer> customers  = customerRepository.findAll(requestedPage);

	

}
