package com.monocept.model;

public class WalletPayment extends Payment {


	public WalletPayment(double amount) {
		super(amount);
	}

	@Override
	public void processPayment() {
		
		validateAmount();
		double fee = amount * 0.01;
		double totalAmount = amount + fee;
		
		System.out.println("===Wallet Payment===");
		System.out.println("PaymentId: "+paymentId);
		System.out.println("Fees: "+fee);
		System.out.println("Total Amount: "+totalAmount);
		
		amount = totalAmount;
		generateReceipt();

	}

}
