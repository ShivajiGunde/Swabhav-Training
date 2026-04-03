package com.monocept.mode;

public class Checkout {
	
	private PaymentGateway paymentGateway;

	public Checkout(PaymentGateway paymentGateway) {
		super();
		this.paymentGateway = paymentGateway;
	}

	 public void makePayment(double amount) {
	        paymentGateway.pay(amount);
	    }

	    public void makeRefund(double amount) {
	        paymentGateway.refund(amount);
	    }
}
