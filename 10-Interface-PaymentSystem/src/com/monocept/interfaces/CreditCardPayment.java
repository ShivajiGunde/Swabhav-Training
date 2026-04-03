package com.monocept.interfaces;

public class CreditCardPayment implements Payment {

	@Override
	public void processPayment(double amount) {
		
		if (amount <= 0) {
			System.out.println("amount cannot be negative");
		return;
		}

		System.out.println("CreditCard Payment: " + amount);
		System.out.println("Payment successfully completed");

	}

}
