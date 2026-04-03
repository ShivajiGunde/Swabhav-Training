package com.loan.model;

public class HomeLoan extends Loan implements LoanEligibility {

	public HomeLoan(String borrowerName, double principalAmount, double interestRate)
			throws InvalidLoanException {
		super(borrowerName, principalAmount, interestRate);
	}

	@Override
	public boolean checkLoanEligibility(double prinncipalAmount) {

		return prinncipalAmount <= 5000000;
	}

	@Override
	public double calculateRepayment() {

		return getPrincipalAmount() + (getPrincipalAmount() * getInterestRate() * 7 / 100);
	}

}
