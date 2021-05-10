package com.hteiktan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hteiktan.dto.EmployeeDTO;
import com.hteiktan.entity.AddressEntity;
import com.hteiktan.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Integer>  {
	List<EmployeeEntity> findByfirstname(String name);
	
//	Page<EmployeeEntity> findAllBySalary(double salary, Pageable pageable);
	
//	@Query("SELECT DISTINCT e.salary FROM Employee e")
//	List<Double> findDistincySalary();
}


//public interface EmployeeRepository {
//	public void insertEmployee(EmployeeEntity emp);
//	public int removeEmployee(int empId);
//	public List<EmployeeEntity> fetchEmployee();
//	public void update(int empId, AddressEntity address);
//}