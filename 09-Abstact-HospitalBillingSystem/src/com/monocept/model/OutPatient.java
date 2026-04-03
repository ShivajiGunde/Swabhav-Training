package com.monocept.model;

public class OutPatient extends Patient {

	private double consultantFee;

	public OutPatient(String name, double consultantFee) {
		super(name);
		this.consultantFee = consultantFee;
	}

	@Override
	public double calculateCharges() {

		return consultantFee;

	}

}
