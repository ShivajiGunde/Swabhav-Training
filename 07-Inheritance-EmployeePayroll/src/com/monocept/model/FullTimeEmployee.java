package com.monocept.model;

public  class FullTimeEmployee extends Employee {
	
	private double basic;
	private double hra;
	private double da;

	public FullTimeEmployee(String name, double salary, double basic, double hra) {
		super(name);
		this.basic = basic;
		this.hra = hra;
		this.da = da;
	}

	
	public  double calculateSalary() {
		
		if (basic < 0 || hra < 0 || da < 0) {
	       
			System.out.println("basic,hra and da  cannot be negative.");
	    }
		return basic+hra+da;
		
	}
	
	
	
}
