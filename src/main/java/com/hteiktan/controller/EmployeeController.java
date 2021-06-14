package com.hteiktan.controller;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hteiktan.dto.AddressDTO;
import com.hteiktan.dto.EmployeeDTO;
import com.hteiktan.dto.Response;
import com.hteiktan.entity.EmployeeEntity;
import com.hteiktan.service.EmployeeService;

import net.sf.jasperreports.engine.JRException;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@GetMapping("/report/{format}")
	public String genericReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return empService.exportReport(format);
	}
	@GetMapping("/custom/pageable")
	public Response retrieveEmployee(@Param(value = "salary") int salary,
										@Param(value = "page") int page,
										@Param(value = "size") int size,
										@Param(value = "agesorting") boolean agesorting,
										@Param(value = "desc") boolean desc) {
		Page<EmployeeEntity> employees = null;
		
		// not filtering with salary
		if(salary < 0) {
			// not sorting with age
			if(agesorting == false) {
				Pageable requestedPage = PageRequest.of(page, size);
				employees = empService.findAll(requestedPage);
			} else {
				// sorting with age and ascending
				if(desc == false) {
					Pageable requestedPage = PageRequest.of(page, size, Sort.by("age"));
					employees = empService.findAll(requestedPage);
				}
				// sorting with age and descending
				else {
					Pageable requestedPage = PageRequest.of(page, size, Sort.by("age").descending());
					employees = empService.findAll(requestedPage);
				}
			}
			
		// filtering with salary
		} else {
			//not sorting with age
			if(agesorting == false) {
				Pageable requestedPage = PageRequest.of(page, size);
				// filtering request by salary
				employees = empService.findAllBySalary(salary, requestedPage);
			} else {
				// sorting with age and ascending
				if(false == desc) {
					Pageable requestedPage = PageRequest.of(page, size, Sort.by("age"));
					// filtering request by salary
					employees = empService.findAllBySalary(salary, requestedPage);
				} 
				// sorting with age and descending
				else {
					Pageable requestedPage = PageRequest.of(page, size, Sort.by("age").descending());
					// filtering request
					employees = empService.findAllBySalary(salary, requestedPage);
				}
				
			}
		}
		Response res = new Response(employees.getContent(), employees.getTotalPages(), employees.getNumber(), employees.getSize());
 		
		return res;
	}
	
	@GetMapping("/salaries")
	public List<Double> getListSalaries() {
		try {
			return empService.getListSalaries();
			
		} catch (Exception e){
			System.out.println(e);
			return Arrays.asList();
		}
	}
	
	@GetMapping(produces="application/json")
	public List<EmployeeDTO> fetchEmployee() {
		return empService.getAllEmployee();
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<EmployeeDTO> createEmployee( @RequestBody EmployeeDTO employeeDTO) {
		String response = "Employee Added Successfully";
		try {
			 empService.insert(employeeDTO);
			 employeeDTO.setSuccessMessage(response);
			 return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK );
			 
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	
	}
	
	@PutMapping(value = "/{empId}", consumes = "application/json")
	public ResponseEntity<Void> updateEmpAddress(@PathVariable("empId") int empId, @RequestBody AddressDTO addressDTO) 
	{
		try {
			empService.updateEmpAddress(empId, addressDTO);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	//	String response = "Employee Address Updated Successfully";
		
	
	}
	
	//Deleting a customer
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("empId") int empId) 
	{
		//String response = "Employee Deleted Successfully";
		try {
			 empService.delete(empId);
			 return ResponseEntity.ok().build();
		}catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}	 
		// return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@GetMapping(value="/findbyname/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeDTO> findByName(@PathVariable String name) {
		List<EmployeeDTO> employees = empService.findByName(name);
		return employees;
	}
	
	
}
