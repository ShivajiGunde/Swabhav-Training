package com.monocept.model;

public class Bike implements Vehicle{

	@Override
	public void start() {
     System.out.println("Bike Started...");		
	}

	@Override
	public void stop() {
System.out.println("Bike Stoped...");		
	}

	@Override
	public void fuelType() {
		
		System.out.println("Fuel Type : Petrol");
		
	}

}
