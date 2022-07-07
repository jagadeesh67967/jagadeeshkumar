package com.zensar.springbootDemo.entity;

public class Employee {
	private int empId;
	private String empName;
	private String empDept;
	public Employee() {
		super();
	}
	public Employee(int empId, String empName, String empDept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDept = empDept;
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
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDept=" + empDept + "]";
	}
	

}
