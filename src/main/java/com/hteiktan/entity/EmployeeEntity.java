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
	@Column(name ="emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
	@Column(name="employee_name")
    private String empName;
    private String department;
	private int age;
    private String gender;
    @Column(name="start_date")
    private LocalDate startDate;
    @Column(name="end_date")
    private LocalDate endDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id", unique=true)
    private AddressEntity address;
    public EmployeeEntity() {
    	
    }
    public EmployeeEntity(int empId, String empName, String department, int age, String gender, LocalDate startDate,
			LocalDate endDate, AddressEntity address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.age = age;
		this.gender = gender;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
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
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
		return "Employee [Name=" + empName + ", Department=" + department +
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
		empDTO.setAddress(addressDTO);
		empDTO.setDepartment(emp.getDepartment());
		empDTO.setEmpName(emp.getEmpName());
		empDTO.setAge(emp.getAge());
		empDTO.setGender(emp.getGender());
		empDTO.setStartDate(emp.getStartDate());
		empDTO.setEndDate(emp.getEndDate());
		
		return empDTO;
	}

}
