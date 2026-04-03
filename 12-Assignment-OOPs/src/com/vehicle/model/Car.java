package com.vehicle.model;

public class Car extends Vehicle{

    private int seatingCapacity;

	public Car(String ownerName, double baseUsageCharge,int seatingCapacity) {
		super(ownerName, baseUsageCharge);
		
		if(seatingCapacity <= 0) {
			throw new IllegalArgumentException("seating Capacity cannot be negative");
		}
		this.seatingCapacity = seatingCapacity;
	}

	@Override
	public void display() {

		System.out.println("RegistrationNumber: "+registrationNumber);
		System.out.println("OwnerName: "+ownerName);
		System.out.println("BaseCharges: "+baseUsageCharge);
		System.out.println("SeatingCapacity: "+seatingCapacity);
	}

}
