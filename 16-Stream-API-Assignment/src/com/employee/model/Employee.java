package com.employee.model;

public class Employee {
	
	private int employeeId;
	private String name;
	private String department;
	private double salary;
	private int experience;
	private boolean activeStatus;
	
	

	public Employee(int employeeId, String name, String department, double salary, int experiance,
			boolean activeStatus) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.experience = experiance;
		this.activeStatus = activeStatus;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public double getSalary() {
		return salary;
	}
	public int getExperience() {
		return experience;
	}
	public boolean getActiveStatus() {
		return activeStatus;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", department=" + department + ", salary="
				+ salary + ", experience=" + experience + ", activeStatus=" + activeStatus + "]";
	}
	
	

}
