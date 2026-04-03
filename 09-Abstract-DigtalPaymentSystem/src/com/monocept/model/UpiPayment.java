package com.monocept.model;

public class UpiPayment extends Payment {

	public UpiPayment(double amount) {
		super(amount);

	}

	@Override
	public void processPayment() {

		validateAmount();
		System.out.println("UPI Payment:");
		System.out.println("PaymentId: "+paymentId);
		System.out.println("No processing fee for upi payment");
		
		generateReceipt();

	}

}
