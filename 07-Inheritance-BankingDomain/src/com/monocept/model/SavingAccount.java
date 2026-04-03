package com.monocept.model;

public class SavingAccount extends Account {

	

	private double minBal;

	public SavingAccount(String accountHolderName, double balance, double minBal) {
		super(accountHolderName, balance);
		
		this.minBal=minBal;
	}

	public double getMinBal() {

		return minBal;
	}
	
	@Override
	public void withdraw(double amount) {
		
		super.withdraw(amount);
   
		if(balance - amount < minBal) {
			System.out.println("Account Balance is less than minimum Balance "+minBal);
			return;
		}
	}
	
  
}
