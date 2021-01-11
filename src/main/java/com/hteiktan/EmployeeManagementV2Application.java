package com.hteiktan;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.hteiktan.dto.EmployeeDTO;
import com.hteiktan.service.EmployeeServiceImpl;
import com.hteiktan.dto.AddressDTO;

@SpringBootApplication
public class EmployeeManagementV2Application {
	
	public static void main(String[] args) {
		EmployeeServiceImpl service = null;
		AbstractApplicationContext context = (AbstractApplicationContext)SpringApplication.run(EmployeeManagementV2Application.class, args);
		service = (EmployeeServiceImpl) context.getBean("employeeService");
		
		AddressDTO address1 = new AddressDTO();
		address1.setCity("Mandalay");
		address1.setStreetName("Pyithayar Road");
		address1.setPincode("MDY333");
		
		EmployeeDTO employee1 = new EmployeeDTO();
		employee1.setAddress(address1);
		employee1.setDepartment("Management");
		employee1.setEmpName("MiBote");
		employee1.setAge(21);
		employee1.setGender("Male");
		employee1.setStartDate(LocalDate.of(2020, 01, 18));
		

		
		EmployeeDTO employee2 = new EmployeeDTO();
		employee2.setAddress(address1);
		employee2.setDepartment("Floor");
		employee2.setEmpName("Ko Ko");
		employee2.setAge(23);
		employee2.setGender("Female");
		employee2.setStartDate(LocalDate.of(2020, 8, 23));
		
//		EmployeeDTO employee3 = new EmployeeDTO();
//		employee3.setAddress(address1);
//		employee3.setDepartment("Management");
//		employee3.setEmpName("MiBote");
		
		service.insert(employee1);
		service.insert(employee2);
		System.out.println("Employees Added Successfully!");

//		service.insert(employee3);
	
	}

}
