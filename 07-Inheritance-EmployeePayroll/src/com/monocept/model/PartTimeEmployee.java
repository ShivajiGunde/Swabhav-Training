package com.monocept.model;

public class PartTimeEmployee extends Employee {
	
	private double hoursWorked;
	private double hourlyRate;

	public PartTimeEmployee(String name, double hoursWorked, double hourlyRate) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double calculateSalary() {
		if (hoursWorked < 0 || hourlyRate < 0) {
	        
			System.out.println("hoursWoked and hourlyRate cannot be negative.");
	    }
		return hoursWorked * hourlyRate;
	}

}
