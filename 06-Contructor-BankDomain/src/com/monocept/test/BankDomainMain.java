package com.monocept.test;

import java.util.Scanner;

import com.monocept.bank.BankAccount;
import com.monocept.bank.PremiumAccount;

public class BankDomainMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Select Account type");
		System.out.println("1. BankAccount");
		System.out.println("2. PremiumAccount");

		System.out.println("Enter your choice");
		int choice = scanner.nextInt();
		
		scanner.nextLine();

		System.out.println("Enter the account holder name");
		String accountHolderName = scanner.nextLine();

		if (choice == 1) {

			System.out.println("Do you want initial balance yes/no");
			String option = scanner.nextLine();

			BankAccount account;
			if (option.equalsIgnoreCase("yes")) {
				System.out.println("Enter initial balance");
				double balance = scanner.nextDouble();

				 account = new BankAccount(accountHolderName,balance);

			}else {
				 account = new BankAccount(accountHolderName);
			}
			System.out.println("Account Created Successfully");
			System.out.println("Account Number: " +account.getAccountNumber());
			System.out.println("AccountHolder Name: "+account.getAccountHolderName());
	        System.out.println("Balance: " +account.getBalance());
	        
	        
		}else if(choice == 2) {
			
			
			System.out.println("Enter initial balance");
			double balance = scanner.nextDouble();
			
			System.out.println("Enter bonus");
			double bonus = scanner.nextDouble();
			
			PremiumAccount account = new PremiumAccount(accountHolderName,balance,bonus);

			System.out.println("Premium Account Created Successfully");
			System.out.println("Account Number: "+account.getAccountNumber());
			System.out.println("Account Holder Name: "+account.getAccountHolderName());
		    System.out.println("Balance: "+account.getBalance());
		}else {
			
			System.out.println("Invalid choice");
		}
		scanner.close();

	}

}
