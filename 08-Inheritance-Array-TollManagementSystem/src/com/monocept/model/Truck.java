package com.monocept.model;

public class Truck extends Vehicle {

	private double weight;

	public Truck(String vehicleNumber, double weight) {
		super(vehicleNumber);
		this.weight = weight;
	}

	@Override
	public double calculateToll() {
     if(weight <= 0) {
    	 
    	 System.out.println("Weight cannot be negative");
     }
		return 200 +(weight * 50);
	}

}
