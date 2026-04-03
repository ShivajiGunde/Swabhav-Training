package com.monocept.mode;

public class CreditCard implements PaymentGateway{
	
	private String cardNumber;

	public CreditCard(String cardNumber) {
		super();
		this.cardNumber = cardNumber;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid: " + amount + "using Credit Card ");
		
	}

	@Override
	public void refund(double amount) {
		System.out.println("Refunded: " + amount + "using Credit Card ");
		
	}

}
