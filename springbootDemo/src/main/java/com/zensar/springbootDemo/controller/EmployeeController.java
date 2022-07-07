package com.zensar.springbootDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springbootDemo.entity.Employee;
import com.zensar.springbootDemo.service.EmployeeService;

@RestController
@RequestMapping("/employee-api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	public EmployeeController() {
		
	}

	//@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
	@GetMapping("/employee/{empId}")
	public Employee getEmployee(@PathVariable("empId") int EmpId) {
		return employeeService.getEmployee(EmpId);
	}

	//@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	//@RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/employees")
	public void insertEmployee(@RequestBody Employee employee) {
		employeeService.insertEmployee(employee);

	}

	//@RequestMapping(value = "employees/{empId}", method = RequestMethod.PUT)
	@PutMapping("employees/{empId}")
	public void updateEmployee(@PathVariable("empId") int EmpId, @RequestBody Employee employee) {
		employeeService.updateEmployee(EmpId, employee);

	}

	//@RequestMapping(value = "employees/{empId}", method = RequestMethod.DELETE)
	@DeleteMapping("employees/{empId}")
	public void deleteEmployee(@PathVariable("empId") int EmpId) {
		employeeService.deleteEmployee(EmpId);
	}
}