package com.loan.model;

public class CarLoan extends Loan implements LoanEligibility {

	public CarLoan(String borrowerName, double principalAmount, double interestRate)
			throws InvalidLoanException {
		super(borrowerName, principalAmount, interestRate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkLoanEligibility(double prinncipalAmount) {

		return prinncipalAmount <= 500000;
	}

	@Override
	public double calculateRepayment() {
		// TODO Auto-generated method stub
		return getPrincipalAmount() + (getPrincipalAmount() * getInterestRate() * 10 / 100);
	}

}
