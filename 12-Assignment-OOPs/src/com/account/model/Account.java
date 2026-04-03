package com.account.model;

public abstract class Account {

	private String accountNumber;
	private String accountHolderName;
	protected double balance;

	public Account(String accountHolderName, double balance) {
		super();
		this.accountNumber = generateAccountNumber();
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	private String generateAccountNumber() {

		return "ACC: " + System.currentTimeMillis();
	}

	public void deposit(double amount) {
		if (amount <= 0) {

			throw new IllegalArgumentException("Amount cannot be negative.");
		}
		balance += amount;
		System.out.println("Amount Deposited in Saving Account " + amount);

	}

	public void withdraw(double amount) {

		if (amount <= 0) {
			throw new IllegalArgumentException("Amount cannot be negative.");
		} else if (amount > balance) {

			throw new IllegalArgumentException("Insufficient balance");

		} else {
			balance -= amount;
			System.out.println("SavingAccount: Amount withdraw successfull " + amount);

		}
	}

	public void checkBalance() {
		System.out.println("Account balance : " + balance);
	}

	public void display() {

		System.out.println("Account Number: " + accountNumber);
		System.out.println("AccountHolder Name: " + accountHolderName);
		System.out.println("Balance: " + balance);
	}

}
