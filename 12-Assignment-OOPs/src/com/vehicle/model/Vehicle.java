package com.vehicle.model;

public abstract class Vehicle {
	
	protected String registrationNumber;
    protected String ownerName;
    protected double baseUsageCharge;
	public Vehicle(String ownerName, double baseUsageCharge) {
		super();
		this.registrationNumber = generateRegistrationNumber();
		
		if(ownerName.isEmpty() || !ownerName.matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("Name cannot be null");
		}
		this.ownerName = ownerName;
		
		if(baseUsageCharge <= 0) {
			
			throw new IllegalArgumentException("Base uses charges cannot be less than 0");
		}
		this.baseUsageCharge = baseUsageCharge;
		
		
	}
	private String generateRegistrationNumber() {

		return "RN"+System.currentTimeMillis();
	}
	
	public abstract void display();

}
