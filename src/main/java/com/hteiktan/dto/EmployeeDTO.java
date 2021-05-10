package com.hteiktan.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.hteiktan.entity.AddressEntity;
import com.hteiktan.entity.EmployeeEntity;

public class EmployeeDTO {
	private int empId;
	private String firstname;
	private String lastname;
	private String department;
	private int age;
	private String gender;
	private double salary;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public EmployeeDTO() {
		
	}
	public EmployeeDTO(String firstname, String lastname, String department, int age, String gender,
			LocalDate startDate, LocalDate endDate, double salary , AddressDTO address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;

	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	private AddressDTO address;

	private String successMessage;
	private String errorMessage;
	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}



	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [Name=" + firstname + " " + lastname + ", Department=" + department + ", Address= [Street Name"
				+ address.getStreetName() + ", City= " + address.getCity() + "]";
	}

	public static EmployeeEntity prepareEmployeeEntity(EmployeeDTO emp) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setCity(emp.getAddress().getCity());
		addressEntity.setPincode(emp.getAddress().getPincode());
		addressEntity.setStreetName(emp.getAddress().getStreetName());

		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity.setAddress(addressEntity);
		empEntity.setDepartment(emp.getDepartment());
		empEntity.setFirstname(emp.getFirstname());
		empEntity.setLastname(emp.getLastname());
		empEntity.setAge(emp.getAge());
		empEntity.setGender(emp.getGender());
		empEntity.setStartDate(emp.getStartDate());
		empEntity.setEndDate(emp.getEndDate());
		empEntity.setSalary(emp.getSalary());
		return empEntity;
	}

}
