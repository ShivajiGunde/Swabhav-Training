package com.monocept.mode;

public class NetBanking implements PaymentGateway{
	
	private String bankName;

	public NetBanking(String bankName) {
		super();
		this.bankName = bankName;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid: " + amount + "using Net banking " + bankName);
		
	}

	@Override
	public void refund(double amount) {
		System.out.println("Refunded: " + amount + "using Net banking  " + bankName);
		
	}

}
