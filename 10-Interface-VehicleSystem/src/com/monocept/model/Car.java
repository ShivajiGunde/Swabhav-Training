package com.monocept.model;

public class Car implements Vehicle{

	@Override
	public void start() {
		
		System.out.println("Car Started..");
		
	}

	@Override
	public void stop() {
		
		System.out.println("Car Stoped...");
		
	}

	@Override
	public void fuelType() {
		
		 System.out.println("Car fuel Type : Petrol or Diesel");
		
	}

}
