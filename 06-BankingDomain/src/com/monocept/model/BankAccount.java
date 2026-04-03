
package com.monocept.model;

public class BankAccount {

    private  final String accountNumber; 
    private String accountHolderName;
    private double balance; 
   

	public BankAccount(String accountHolderName,double balance) {
        this.accountNumber = generateAccountNumber(); 
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	
	public String getAccountHolderName() {
		
		return accountHolderName;
	}
	

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    

    
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }
        balance += amount;
        

    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;
    }
    
    

    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis(); 
    }
}
