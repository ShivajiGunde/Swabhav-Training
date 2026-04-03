package com.monocept.model;

public abstract class Employee {

	protected long employeeId;
	private String name;
    protected double salary;

	private static long counter = 1000;

	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static long generateEmployeeId() {

		return ++counter;
	}
	
	public abstract double calculateSalary();
	
	public void displayEmployee() {
		System.out.println(" Employee ID: " + employeeId);
        System.out.println("Name       : " + name);
        System.out.println("Salary     : " + salary);
	}

}
