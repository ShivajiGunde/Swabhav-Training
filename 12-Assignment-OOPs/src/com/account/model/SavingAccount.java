package com.account.model;

public class SavingAccount extends Account{

	private double interestRate;
	
	public SavingAccount(String accountHolderName, double balance,double interestRate) {
		super(accountHolderName,balance);
		
		this.interestRate = interestRate;
	}

	@Override
	public void display() {
       super.display();
       System.out.println("Account type: Saving");
       System.out.println("InterestRate: "+interestRate+ "%");
	}
	

}
