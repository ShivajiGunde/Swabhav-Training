package com.monocept.model;

public class InPatient extends Patient {

	private double roomCharges;

	public InPatient(String name,double roomCharges) {
		super(name);

		this.roomCharges = roomCharges;

	}

	@Override
	public double calculateCharges() {

		return roomCharges;

	}

}
