package com.monocept.model;

public class SavingsAccount implements AccountOperations {

	private String name;
	private double balance;
	private double withdrawalLimit;

	public SavingsAccount(String name, double balance, double withdrawalLimit) {
		this.name = name;
		this.balance = balance;
		this.withdrawalLimit = withdrawalLimit;
	}

	@Override
	public void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Amount cannot be negative.Enter valid amount");
			return;
		}
		balance += amount;
		System.out.println("Amount Deposited in Saving Account " + amount);

	}

	@Override
	public void withdraw(double amount) {
		if (amount > withdrawalLimit) {

			System.out.println("Saving Account: Withdrawal Limit exceeded");

		} else if (amount > balance) {

			System.out.println("Saving Account: Insufficient balance");

		} else if(amount <= 0){
			
			System.out.println("Amount must be positive");
		}else {
			balance -= amount;
			System.out.println("SavingAccount: Amount withdraw successfull " + amount);
		}
	}

	
	@Override
	public void checkBalance() {
		System.out.println("Saving Account balance : " + balance);

	}

}
