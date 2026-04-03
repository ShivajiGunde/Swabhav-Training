package com.monocept.model;

public class LoanAccount implements AccountOperations {

    private String name;
    private double loanAmount;

    public LoanAccount(String name, double loanAmount) {
        this.name = name;
        this.loanAmount = loanAmount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
        } else {
            loanAmount += amount; 
            System.out.println("Loan Account: Loan amount increased by " + amount);
        }
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Deposits are not allowed in Loan account.");
    }

    @Override
    public void checkBalance() {
        System.out.println("Loan Account balance: " + loanAmount);
    }
}