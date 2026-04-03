package com.monocept.model;

public class CorporateClaim extends InsurenceClaim {

	private double processingFee;

	public CorporateClaim(double claimAmount, double processingFee) {
		super(claimAmount);

		this.processingFee = processingFee;
	}

	public double getProcessingFee() {
		return processingFee;
	}

}
