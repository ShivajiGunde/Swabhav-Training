package com.monocept.bank;

public class BankAccount {

	private final String accountNumber;
	private String accountHolderName;
	protected double balance;
    private static double interestRate;
    
    static {
    	interestRate = 5;
    }


	public BankAccount(String accountHolderName) {
		super();
		this.accountNumber = generateAccountNumber();
		this.accountHolderName = accountHolderName;
		this.balance = 0.0;

	}

	public BankAccount(String accountHolderName,double balance) {
		super();
		this.accountNumber = generateAccountNumber();
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		
		if(balance < 0) {
			System.out.println("Balance cannot be negative");
		}

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

		return "ACC" + System.currentTimeMillis();
	}

}
