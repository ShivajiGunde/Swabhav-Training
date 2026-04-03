package com.account.model;

public class CurrentAccount extends Account{
	
	private double overDraftLimit;

	public CurrentAccount(String accountHolderName,double balance,double overDraftLimit) {
		super(accountHolderName,balance);
		this.overDraftLimit = overDraftLimit;
	}
	

	@Override
	public void withdraw(double amount) {
		if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (amount > balance + overDraftLimit) {
            throw new IllegalArgumentException("Overdraft limit exceeded");
        }

        balance -= amount;
        System.out.println("Withdrawal successful: " + amount);
    }
	
	
	@Override
	public void display() {
       super.display();
       System.out.println("Account type: CurrentAccount");
       System.out.println("OverdraftLimit: "+overDraftLimit);
	}

	}


