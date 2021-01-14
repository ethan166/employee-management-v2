package com.hteiktan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<String> createEmployee( @RequestBody EmployeeDTO employeeDTO) {
		String response = "Employee Added Successfully";
		
		 empService.insert(employeeDTO);
		 return ResponseEntity.ok(response);
	}
	
	@PutMapping(value = "/{empId}", consumes = "application/json")
	public ResponseEntity<String> updateEmpAddress(@PathVariable("empId") int empId, @RequestBody AddressDTO addressDTO) 
	{
		String response = "Employee Address Updated Successfully";
		empService.updateEmpAddress(empId, addressDTO);
		return ResponseEntity.ok(response);
	}
	
	//Deleting a customer
	@DeleteMapping("/{empId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("empId") int empId) 
	{
		String response = "Employee Deleted Successfully";
		
		 empService.delete(empId);
		 return ResponseEntity.ok(response);
	}
	
	
}
