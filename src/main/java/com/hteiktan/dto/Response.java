package com.hteiktan.dto;

import java.util.List;

import com.hteiktan.entity.EmployeeEntity;

public class Response {
	private List<EmployeeEntity> employees;
	private int totalPages;
	private int pageNumber;
	private int pageSize;
	
	public Response() {}

	public Response(List<EmployeeEntity> employees, int totalPages, int pageNumber, int pageSize) {
		super();
		this.employees = employees;
		this.totalPages = totalPages;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
