package com.monocept.model;

public class ContractEmployee extends Employee{

	private double fixedAmount;
	private double tax;

	
	public ContractEmployee(String name, double fixedAmount, double tax) {
		super(name);
		this.fixedAmount = fixedAmount;
		this.tax = tax;
	}

	@Override
	public double calculateSalary() {
		
		if (fixedAmount < 0 || tax < 0 ) {
			
	        System.out.println("fixedAmount and tax cannot be negative.");
	    }
		
		return fixedAmount - tax;
		
		
	}

}
