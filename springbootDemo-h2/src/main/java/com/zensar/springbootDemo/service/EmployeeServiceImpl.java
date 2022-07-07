package com.zensar.springbootDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.springbootDemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	List<Employee> employees = new ArrayList<Employee>();
	public EmployeeServiceImpl() {
		employees.add(new Employee(1, "John", "Testing"));
		employees.add(new Employee(2, "Abraham", "Developer"));
		employees.add(new Employee(3, "Lincoln", "Engineer"));
	}
	@Override
	public Employee getEmployee(int EmpId) {
		for (Employee employee : employees) {
			if (employee.getEmpId() == EmpId) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public void insertEmployee(Employee employee) {
		employees.add(employee);
		
	}

	@Override
	public void updateEmployee(int EmpId, Employee employee) {
		Employee emp = getEmployee(EmpId);
		emp.setEmpId(employee.getEmpId());
		emp.setEmpName(employee.getEmpName());
		emp.setEmpDept(employee.getEmpDept());
		employees.add(emp);
		
	}

	@Override
	public void deleteEmployee(int EmpId) {
		for(int i=0;i<employees.size();i++) {
			Employee employee = employees.get(i);
			if(employee.getEmpId()==EmpId) {
				employees.remove(employee);
			}
		}
		
	}

}
