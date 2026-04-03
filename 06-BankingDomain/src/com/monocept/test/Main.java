package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.BankAccount;

public class Main {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter account holder name");
		String name = scanner.nextLine();
		
		System.out.println("Enter initial balance");
		double balance = scanner.nextDouble();
		
		BankAccount account = new BankAccount(name,balance);


		boolean running = true;

		while (running) {

			System.out.println("Enter your choice");
			System.out.println(" 1.deposit \n 2.withdraw \n 3.balance \n 4.exit");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter deposit amount");
				double depositAmount = scanner.nextDouble();
				account.deposit(depositAmount);
				System.out.println("Deposit Amount: " + depositAmount);
				break;

			case 2:
				System.out.println("Enter withdraw  amount");
				double withdrawAmount = scanner.nextDouble();
				account.withdraw(withdrawAmount);
				System.out.println("Withdrawal amount: " + withdrawAmount);
				break;
			case 3:
				System.out.println("Balance "+account.getBalance());
				break;

			case 4:
				running = false;
				System.out.println("Exit");
				break;

			default:
				System.out.println("Invalid Choice");
			}
		}
		scanner.close();
	}

}
