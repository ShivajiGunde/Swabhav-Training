package com.monocept.model;

public class CurrentAccount extends Account {

	private double overdraftLimit;

	public CurrentAccount(String accountHolderName, double balance, double overdraftLimit) {
		super(accountHolderName, balance);
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public void withdraw(double amount) {
		if (balance - amount < -overdraftLimit) {

			System.out.println("Exceeded overdraftLimit");
			return;
		} 
			balance -= amount;
			System.out.println("Withdrawal successful. New balance: " + balance);
		}

	

	public double getOverdraftLimit() {
		return overdraftLimit;

	}

}
