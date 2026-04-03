package com.monocept.model;

public abstract class Patient {

	private int patientId;
	private String name;
	
	private static int counter = 100;

	public Patient( String name) {
		super();
		this.patientId = ++counter;
		this.name = name;
	}

	

	public abstract double calculateCharges();

	public void generateBill() {
		double charges = calculateCharges();
		double tax = charges * 0.10;
		double finalAmount = charges + tax;

		System.out.println("===BillDetails===");
		System.out.println("charges: " + charges);
		System.out.println("Tax: " + tax);
		System.out.println("finalAmount: " + finalAmount);

	}

}
