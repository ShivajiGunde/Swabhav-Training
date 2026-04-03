package com.monocept.model;

public class InsurenceClaim {

	private final String claimId;
	private long policyNumber;
	private double claimAmount;
	private ClaimStatus claimStatus;
	private double approvedAmount;

	public enum ClaimStatus {
		FILED, APPROVED, REJECTED, SETTLED
	}

	private static long counter = 1000;

	public InsurenceClaim(double amount) {
		super();
		this.claimId = generateClaimId();
		this.policyNumber = generatePolicyNumber();
		this.claimAmount = amount;
		this.claimStatus = ClaimStatus.FILED;
		this.approvedAmount = 0;
	}

	

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {

		if (claimAmount < 0) {

			System.out.println("claim Amount cannot be negative");
		}
		this.claimAmount = claimAmount;
	}

	public ClaimStatus getClaimStatus() {
		return claimStatus;
	}

	public double getApprovedAmount() {
		return approvedAmount;
	}

	public void setApprovedAmount(double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public String getClaimId() {
		return claimId;
	}

	// Generating claimId
	private String generateClaimId() {

		return "ClaimId" + System.currentTimeMillis();

	}

	// Generating policyNumber
	private static Long generatePolicyNumber() {
		return ++counter;
	}

	
	// ApproveClaim method
	public void approveClaim(double amount) {
		ensureNotSettled();

		if (claimStatus != ClaimStatus.FILED) {

			System.out.println("Only filed claims approve");
			return;
		}
		if (amount < 0) {

			System.out.println("Claim amount cannot be negative");
			return;

		} else if (amount > claimAmount) {

			System.out.println("approved amount cannot exceed claim amount");
			return;
		}

		this.approvedAmount = amount;
		this.claimStatus = ClaimStatus.APPROVED;
		
		System.out.println("Claim approved successfully");
	}

	
	//Claim reject method
	
	public void rejectClaim() {
		ensureNotSettled();

		if (claimStatus != ClaimStatus.FILED) {
			System.out.println("Only filed claims reject");
		}

		this.claimStatus = ClaimStatus.REJECTED;
	}

	
	
	//Settlement Method
	
	public void settleClaim() {
		ensureNotSettled();

		if (claimStatus != claimStatus.APPROVED && claimStatus != claimStatus.REJECTED) {

			System.out.println("claims must be approved or rejected before settlment ");
		}

		this.claimStatus = ClaimStatus.SETTLED;
	}

	private void ensureNotSettled() {
		if (claimStatus == ClaimStatus.SETTLED) {

			System.out.println("Settled claims cannot be modified.");
		}
	}
	
	public void displayClaimDetails() {
	System.out.println("======Print claim details========");
	System.out.println("claim id : "+claimId);
	System.out.println("Policy Number: "+policyNumber);
	System.out.println("Claim amount: "+claimAmount);
	System.out.println("Claim Status: "+claimStatus);
	System.out.println("Approved Amount: "+approvedAmount);
	}
}
