package com.monocept.model;

public abstract class Payment {
	
	protected String paymentId;
	protected double amount;
	
	

	public Payment(double amount) {
		super();
		this.paymentId = generatePaymentId();
		this.amount = amount;
	}
	
	 
	public abstract void processPayment();

	
	public void validateAmount() {
		
	if(amount <= 0) {
		System.out.println("Amount cannot be negative");
	  return;
	}
	}
	public  void  generateReceipt() {
		
		System.out.println("=====Payment Receipt====");
		 System.out.println("Payment successful!");
		 System.out.println("PaymentId: "+paymentId);
	     System.out.println("Amount Paid: " + amount);		
	}
	
	public String generatePaymentId() {
		
		return "PaymentId: "+System.currentTimeMillis();
	}
	
}
