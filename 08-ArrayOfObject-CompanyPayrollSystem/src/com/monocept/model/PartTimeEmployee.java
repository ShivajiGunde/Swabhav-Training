package com.monocept.model;

public class PartTimeEmployee extends Employee{
	
	private double hoursWorked;
	private double hourlyRate;

	public PartTimeEmployee(long empId, String name,double hoursWorked,double hourlyRate) {
		super(empId, name);
		
		this.hoursWorked=hoursWorked;
		this.hourlyRate=hourlyRate;
	}

	@Override
	public double calculateSalary() {
		
		if (hoursWorked < 0 || hourlyRate < 0) {
			
			System.out.println("hoursWoked and hourlyRate Cannot be negative");
		}

		return hoursWorked * hourlyRate;
	  
	}
	
	 @Override
	    public void displayEmployeeDetails() {
	        super.displayEmployeeDetails();
	       	        
	        System.out.println("Employee Type: Part Time");
	        System.out.println("Hours Worked: " + hoursWorked);
	        System.out.println("Hourly Rate: " + hourlyRate);
	        System.out.println("Total Salary: " + calculateSalary());
	    }

}
