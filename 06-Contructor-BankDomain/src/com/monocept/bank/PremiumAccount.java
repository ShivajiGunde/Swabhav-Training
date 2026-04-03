package com.monocept.bank;

public class PremiumAccount extends BankAccount {

	private double bonus;

	

	public PremiumAccount(String accountHolderName, double balance, double bonus) {
		super(accountHolderName, balance);

		if (bonus < 0) {

			System.out.println("bonus can not be negative");
		}
		this.bonus = bonus;
		this.balance += bonus;

	}
}
