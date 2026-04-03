package com.monocept.model;

public class FullTimeEmployee extends Employee {

	private double basic;
	private double hra;
	private double da;

	public FullTimeEmployee(long empId, String name, double basic, double hra, double da) {
		super(empId, name);
		this.basic = basic;
		this.hra = hra;
		this.da = da;

	}

	@Override
	public double calculateSalary() {
		if (basic < 0 || hra < 0 || da < 0) {
		       
			System.out.println("basic,hra and da  cannot be negative.");
	    }

		return basic + hra + da;
	}
	
	@Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        
        System.out.println("Employee Type: Full Time");
        System.out.println("Basic Salary: " + basic);
        System.out.println("HRA: " + hra);
        System.out.println("DA: " + da);
        System.out.println("Total Salary: " + calculateSalary());
    }

}
