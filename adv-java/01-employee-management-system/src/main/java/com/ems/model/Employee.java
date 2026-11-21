package com.ems.model;

public class Employee {
		
	private int employeeid;
	private String employeeName;
	private String email;
	private double salary;
	private String department;
	
	public Employee() {
		
	}

	public Employee(int employeeid, String employeeName, String email, double salary, String department) {
		super();
		this.employeeid = employeeid;
		this.employeeName = employeeName;
		this.email = email;
		this.salary = salary;
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
