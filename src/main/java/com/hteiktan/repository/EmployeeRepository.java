package com.hteiktan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hteiktan.dto.EmployeeDTO;
import com.hteiktan.entity.AddressEntity;
import com.hteiktan.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>  {

}
