package com.monocept.interfaces;

public class DebitCardPayment implements Payment{

	@Override
	public void processPayment(double amount) {
		if (amount <= 0) {
			System.out.println("amount cannot be negative");
		return;
		}
		System.out.println("Debit Card Payment: "+amount);
		System.out.println("Payment completed successfully");
	}

}
