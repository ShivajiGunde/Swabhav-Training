package com.monocept.model;

public class Intern extends Employee {

	private double fixedAmount;

	public Intern(long empId, String name, double fixedAmount) {
		super(empId, name);
		this.fixedAmount = fixedAmount;

	}

	@Override
	public double calculateSalary() {
		
		return fixedAmount;
	}
	
	 @Override
	    public void displayEmployeeDetails() {
	        super.displayEmployeeDetails();
	        System.out.println("Employee Type: Intern");
	        System.out.println("Stipend: " + fixedAmount);
	    }
	}
	


