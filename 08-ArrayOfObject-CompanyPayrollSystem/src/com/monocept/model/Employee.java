package com.monocept.model;

public class Employee {
	
	protected long empId;
	private String name;
    protected double salary;
    
    public Employee(long empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	private static int totalEmployees=0;
    
    public double calculateSalary() {

		if (salary < 0) {

			System.out.println("Base fee cannot be negative");
		}
		return salary;
	}

	

	public static int getTotalEmployees() {

		return totalEmployees;
	}
	
	public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + name);
    }

}
