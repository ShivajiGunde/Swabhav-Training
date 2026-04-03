package com.monocept.mode;

public class UPI implements PaymentGateway {
	private String upiId;

	public UPI(String upiId) {
		super();
		this.upiId = upiId;
	}

	@Override
	public void pay(double amount) {

		System.out.println("Paid: " + amount + "using UPI ID " + upiId);
	}

	@Override
	public void refund(double amount) {
		System.out.println("Refunded " + amount + " to UPI ID " + upiId);

	}

}
