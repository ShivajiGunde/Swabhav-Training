package com.monocept.model;

public class CreditCardPayment extends Payment {

	public CreditCardPayment(double amount) {
		super(amount);

	}

	@Override
	public void processPayment() {

		validateAmount();

		double fee = amount * 0.02;
		double totalAmount = amount + fee;

		System.out.println("Credit Card Payment ");
		System.out.println("PaymentId : "+paymentId);
		System.out.println("Card Fee: " + fee);
		System.out.println("Total amount: " + totalAmount);

		amount = totalAmount;
		generateReceipt();

	}

}
