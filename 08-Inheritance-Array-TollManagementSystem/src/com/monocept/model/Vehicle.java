package com.monocept.model;

public class Vehicle {

	public String vehicleNumber;

	protected static double totalVehiclesProcessed = 0;
	protected static double totalTollCollected = 0;

	public Vehicle(String vehicleNumber) {
		super();

		this.vehicleNumber = vehicleNumber;
	}

	public double calculateToll() {

		return calculateToll();
	}

	public double calculateToll(double distance) {

		return calculateToll() * distance;
	}

	public static void updateTotals(double toll) {
		if (toll < 0) {
			
			System.out.println("toll cannot be negative");

		}
		totalVehiclesProcessed++;
		totalTollCollected += toll;
	}

	public static void displayTotals() {
		System.out.println("Total Vehicles Processed : " + totalVehiclesProcessed);
		System.out.println("Total Toll Collected     : ₹" + totalTollCollected);
	}
}
