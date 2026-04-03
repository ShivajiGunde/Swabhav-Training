package com.monocept.model;

import com.monocept.model.InsurenceClaim;

public class InsurenceClaim {

	private final String claimId;
	private long policyNumber;
	private double claimAmount;
	private String status;
	private double approvedAmount;

	private static long counter = 1000;

	public InsurenceClaim(double claimAmount) {

		super();
		
		this.claimId = generateClaimId();
		this.policyNumber = generatePolicyNumber();
		this.claimAmount = claimAmount;
		this.status = "Filed";
		this.approvedAmount = 0.0;
	}

	// Generating claimId
	private String generateClaimId() {

		return "ClaimId" + System.currentTimeMillis();

	}

	// Generating policyNumber
	private static Long generatePolicyNumber() {
		return ++counter;
	}

	public String getClaimId() {
		return claimId;
	}

	public long getPolicyNumber() {
		return policyNumber;

	}

	public double getClaimAmount() {
		return claimAmount;

	}

	public String getStatus() {
		return status;

	}

	public double getApprovedAmount() {
		return approvedAmount;

	}

}
