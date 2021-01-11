package com.hteiktan.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hteiktan.dto.EmployeeDTO;
import com.hteiktan.entity.AddressEntity;
import com.hteiktan.entity.EmployeeEntity;

@Repository("employeeRepository")
@Scope("singleton")
public class EmployeeRepositoryImpl implements EmployeeRepository {
//	
//	List<EmployeeDTO> employee = null;
//	
//	@PostConstruct
//	public void initializer() {
//		// where we connect to database
//		EmployeeDTO employeeDTO = new EmployeeDTO();
//		employeeDTO.setEmpId(101);
//		employeeDTO.setEmpName("Jack");
//		employeeDTO.setDepartment("ETA");
//		employee = new ArrayList<EmployeeDTO>();
//		employee.add(employeeDTO);
//	}
	private EntityManagerFactory entityManagerFactory;
	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	public void insertEmployee(EmployeeDTO emp) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setCity(emp.getAddress().getCity());
		addressEntity.setPincode(emp.getAddress().getPincode());
		addressEntity.setStreetName(emp.getAddress().getStreetName());
		
		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity.setAddress(addressEntity);
		empEntity.setDepartment(emp.getDepartment());
		empEntity.setEmpName(emp.getEmpName());
		empEntity.setAge(emp.getAge());
		empEntity.setGender(emp.getGender());
		empEntity.setStartDate(emp.getStartDate());
		empEntity.setEndDate(emp.getEndDate());
		
		entityManager.getTransaction().begin();
		entityManager.persist(empEntity);
		entityManager.getTransaction().commit();
	}
	
	public void removeEmployee(int empId) {
		//employee.remove(empId);
	}


	public List<EmployeeDTO> fetchEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
}

