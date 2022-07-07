package com.zensar.springbootDemo.service;

import java.util.List;

import com.zensar.springbootDemo.entity.Employee;

public interface EmployeeService {
	public Employee getEmployee(int EmpId);
	public List<Employee> getEmployees();
	public void insertEmployee(Employee employee);
	public void updateEmployee( int EmpId, Employee employee);
	public void deleteEmployee(int EmpId);
}
