package com.monocept.model;

public class CurrentAccount implements AccountOperations {

    private String name;
    private double balance;
    private double overdraftLimit;

    public CurrentAccount(String name, double balance, double overdraftLimit) {
        this.name = name;
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount cannot be negative. Enter a valid amount.");
            return;
        }
        balance += amount;
        System.out.println("Amount deposited in Current Account: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
        } else if (balance - amount < -overdraftLimit) {
            System.out.println("Current Account: Withdrawal limit exceeded!");
        } else {
            balance -= amount;
            System.out.println("Current Account: Amount withdrawn successfully: " + amount);
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Account Balance: " + balance);
    }
}