package com.hteiktan.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hteiktan.dto.AddressDTO;
import com.hteiktan.dto.EmployeeDTO;

@Entity
@Table(name="employee")
public class EmployeeEntity {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
	@Column
    private String firstname;
	
	@Column
	private String lastname;
	
	@Column
    private String department;
	
	@Column
	private int age;
	
	@Column
    private String gender;
	
    @Column
    private LocalDate startDate;
    
    @Column
    private LocalDate endDate;
    
    @Column
    private double salary;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id", unique=true)
    private AddressEntity address;
    
    public EmployeeEntity() {
    	
    }
    public EmployeeEntity(String firstname, String lastname, String department, int age, String gender, LocalDate startDate,
			LocalDate endDate, double salary, AddressEntity address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.age = age;
		this.gender = gender;
		this.startDate = startDate;
		this.endDate = endDate;
		this.salary = salary;
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

	
	public AddressEntity getAddress() {
		return address;
	}
	
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Employee [Name=" + firstname + " " +  lastname + ", Department=" + department +
				", Address= [Street Name" + address.getStreetName() +  ", City= " + address.getCity() + "]";
	}
	
	
	public static EmployeeDTO prepareEmployeeDTO(EmployeeEntity emp) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddressId(emp.getAddress().getAddressId());
		addressDTO.setCity(emp.getAddress().getCity());
		addressDTO.setPincode(emp.getAddress().getPincode());
		addressDTO.setStreetName(emp.getAddress().getStreetName());
		
		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.setEmpId(emp.getEmpId());
		empDTO.setFirstname(emp.getFirstname());
		empDTO.setLastname(emp.getLastname());
		empDTO.setAddress(addressDTO);
		empDTO.setDepartment(emp.getDepartment());
		empDTO.setAge(emp.getAge());
		empDTO.setGender(emp.getGender());
		empDTO.setStartDate(emp.getStartDate());
		empDTO.setEndDate(emp.getEndDate());
		empDTO.setSalary(emp.getSalary());
		
		return empDTO;
	}

}
