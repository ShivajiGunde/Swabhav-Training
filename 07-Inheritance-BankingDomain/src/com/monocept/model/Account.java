package com.monocept.model;

public class Account {
	
	private  String acountNumber;
	private String accountHolderName;
	protected double balance;
	
	public Account(String accountHolderName, double balance) {
		super();
		this.acountNumber = generateAccountNumber();
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	
	public String generateAccountNumber() {
		
		return "AccountNumber:"+System.currentTimeMillis();
	}
	
	public void deposit(double amount) {
		
		if(amount < 0) {
			System.out.println("deposit amount must be positive");
			return;
		}
		balance += amount;
	}
	
	public void withdraw(double amount) {
		if(amount <= 0) {
			System.out.println("Withdrawal Amount must be grater than 0");
			return;
		}
		if(amount > balance) {
			System.out.println("Insufficient fund");
			return;
		}
		balance -= amount;
		
	}
	
	public void displayDetails() {
		
		System.out.println("Account Number: " +generateAccountNumber());
		System.out.println("Account Holder Name: "+accountHolderName);
		System.out.println("Balance: "+balance);
	}
	
	

}
