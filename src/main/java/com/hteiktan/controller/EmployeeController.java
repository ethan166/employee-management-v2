package com.hteiktan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.hteiktan.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
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
