package com.hteiktan;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.hteiktan.dto.EmployeeDTO;
import com.hteiktan.service.EmployeeServiceImpl;

@SpringBootApplication
public class EmployeeManagementV2Application {

	public static void main(String[] args) {
		EmployeeServiceImpl service = null;
		AbstractApplicationContext context = (AbstractApplicationContext)SpringApplication.run(EmployeeManagementV2Application.class, args);
		service = (EmployeeServiceImpl) context.getBean("employeeService");
		
		EmployeeServiceImpl service2 = null;
		service2 = (EmployeeServiceImpl) context.getBean("employeeService");
		System.out.println(service.hashCode() == service2.hashCode());
		System.out.println(service.hashCode());
		System.out.println(service2.hashCode());
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(102);
		employeeDTO.setEmpName("Mini");
		employeeDTO.setDepartment("ETA");
		service.insert(employeeDTO);
		List<EmployeeDTO> list = service.getAllEmployee();
		System.out.println("After adding.....");
		System.out.println("EmployeeName" + "   " + "Department");
		
		for (EmployeeDTO e: list) {
			System.out.format("%5s%15s%n", e.getEmpName(), e.getDepartment());
		}
		System.out.println("\n");
		service.delete(1);
		System.out.println("After deleting Mini.....");
		List<EmployeeDTO> list2 = service.getAllEmployee();
		System.out.println("EmployeeName" + "   " + "Department");
		
		for (EmployeeDTO e: list) {
			System.out.format("%5s%15s%n", e.getEmpName(), e.getDepartment());
		}
	
	}

}
