package com.account.test;

import java.util.Scanner;

import com.account.model.Account;
import com.account.model.CurrentAccount;
import com.account.model.SavingAccount;

public class AccountManagementSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of Accounts:");
		int n = scanner.nextInt();
		scanner.nextLine();

		Account[] account = new Account[n];

		for (int i = 0; i < n; i++) {

			System.out.println("\nEnter details for Account " + (i + 1));

			System.out.println("Select Account Type");
			System.out.println("1. Savings Account");
			System.out.println("2. Current Account");

			int accountType = scanner.nextInt();
			scanner.nextLine();

			try {

				switch (accountType) {

				case 1:

					System.out.println("Enter Account Holder Name:");
					String sName = scanner.nextLine();

					if (sName.isEmpty() || !sName.matches("[a-zA-Z ]+")) {
						throw new IllegalArgumentException("Invalid name! Use letters only.");
					}

					System.out.println("Enter initial balance:");
					double balance = scanner.nextDouble();

					if (balance <= 0) {
						throw new IllegalArgumentException("Invalid balance! Must be positive.");
					}

					System.out.println("Enter Interest Rate:");
					double interestRate = scanner.nextDouble();

					if (interestRate <= 0) {
						throw new IllegalArgumentException("Invalid interest rate.");
					}

					account[i] = new SavingAccount(sName, balance, interestRate);
					System.out.println("Savings Account created successfully!");
					break;

				case 2:

					System.out.println("Enter Account Holder Name:");
					String cName = scanner.nextLine();

					if (cName.isEmpty() || !cName.matches("[a-zA-Z ]+")) {
						throw new IllegalArgumentException("Invalid name! Use letters only.");
					}

					System.out.println("Enter initial balance:");
					double cBalance = scanner.nextDouble();

					if (cBalance <= 0) {
						throw new IllegalArgumentException("Invalid balance! Must be positive.");
					}

					System.out.println("Enter overdraft limit:");
					double overdraft = scanner.nextDouble();

					if (overdraft <= 0) {
						throw new IllegalArgumentException("Invalid overdraft amount.");
					}

					account[i] = new CurrentAccount(cName, cBalance, overdraft);
					System.out.println("Current Account created successfully!");
					break;

				default:
					System.out.println("Invalid choice");
					i--;
					continue;
				}

				boolean running = true;

				while (running) {

					System.out.println("\nSelect Operation");
					System.out.println("1. Deposit");
					System.out.println("2. Withdraw");
					System.out.println("3. Check Balance");
					System.out.println("4. Display Account");
					System.out.println("5. Next Account");

					int choice = scanner.nextInt();

					try {
						switch (choice) {

						case 1:
							System.out.println("Enter amount to deposit:");
							double depositAmount = scanner.nextDouble();

							if (depositAmount <= 0) {
								throw new IllegalArgumentException("Amount must be positive.");
							}

							account[i].deposit(depositAmount);
							break;

						case 2:
							System.out.println("Enter amount to withdraw:");
							double withdrawAmount = scanner.nextDouble();

							if (withdrawAmount <= 0) {
								throw new IllegalArgumentException("Amount must be positive.");
							}

							account[i].withdraw(withdrawAmount);
							break;

						case 3:
							account[i].checkBalance();
							break;

						case 4:
							account[i].display();
							break;

						case 5:
							running = false;
							break;

						default:
							System.out.println("Invalid choice");
						}
					} catch (Exception e) {

						System.out.println("Error " + e.getMessage());
					}
				}
			} catch (IllegalArgumentException e) {

				System.out.println("Error: " + e.getMessage());
				i--;
			}
		}

		scanner.close();
	}
}