package com.monocept.test;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.monocept.model.AccountOperations;
import com.monocept.model.CurrentAccount;
import com.monocept.model.LoanAccount;
import com.monocept.model.SavingsAccount;

public class BankingSystem {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Pattern namePattern = Pattern.compile("^[a-zA-Z]+( [a-zA-Z]+)*$");
		Pattern amountPattern = Pattern.compile("^\\d+(\\.\\d+)?$");

		boolean running = true;
		AccountOperations account = null;

		while (running) {
			System.out.println("\nSelect Account Type");
			System.out.println("1. Savings Account");
			System.out.println("2. Current Account");
			System.out.println("3. Loan Account");
			System.out.println("4. Exit");

			int accountType = Integer.parseInt(scanner.nextLine().trim());

			switch (accountType) {
			case 1:
				String sName;
				while (true) {
					System.out.println("Enter Account Holder Name:");
					sName = scanner.nextLine();
					if (namePattern.matcher(sName).matches())
						break;
					System.out.println("Invalid name! Use letters and spaces only.");
				}

				String balanceInput;
				double balance;
				while (true) {
					System.out.println("Enter the initial amount:");
					balanceInput = scanner.nextLine();
					
					if (amountPattern.matcher(balanceInput).matches()) {
						balance = Double.parseDouble(balanceInput);
						break;
					}
					System.out.println("Invalid amount! Enter a positive number.");
				}

				String withdrawalInput;
				double withdrawalLimit;
				while (true) {
					System.out.println("Enter withdrawal limit:");
					withdrawalInput = scanner.nextLine();
					
					if (amountPattern.matcher(withdrawalInput).matches()) {
						withdrawalLimit = Double.parseDouble(withdrawalInput);
						break;
					}
					System.out.println("Invalid amount! Enter a positive number.");
				}

				account = new SavingsAccount(sName, balance, withdrawalLimit);
				System.out.println("Savings account created successfully!");
				break;

			case 2:
				
				String cName;
				while (true) {
					System.out.println("Enter Account Holder Name:");
					cName = scanner.nextLine();
					
					if (namePattern.matcher(cName).matches())
						break;
					System.out.println("Invalid name! Use letters and spaces only.");
				}

				String cBalanceInput;
				double cBalance;
				while (true) {
					System.out.println("Enter initial balance:");
					cBalanceInput = scanner.nextLine();
					
					if (amountPattern.matcher(cBalanceInput).matches()) {
						cBalance = Double.parseDouble(cBalanceInput);
						break;
					}
					System.out.println("Invalid amount! Enter a positive number.");
				}

				String overdraftInput;
				double overdraft;
				while (true) {
					System.out.println("Enter overdraft limit:");
					overdraftInput = scanner.nextLine();
					
					if (amountPattern.matcher(overdraftInput).matches()) {
						overdraft = Double.parseDouble(overdraftInput);
						break;
					}
					System.out.println("Invalid amount! Enter a positive number.");
				}

				account = new CurrentAccount(cName, cBalance, overdraft);
				System.out.println("Current account created successfully!");
				break;

			case 3:
				String lName;
				while (true) {
					System.out.println("Enter Account Holder Name:");
					lName = scanner.nextLine();
					
					if (namePattern.matcher(lName).matches())
						break;
					System.out.println("Invalid name! Use letters and spaces only.");
				}

				String loanInput;
				double loanAmount;
				while (true) {
					System.out.println("Enter loan amount:");
					loanInput = scanner.nextLine();
					
					if (amountPattern.matcher(loanInput).matches()) {
						loanAmount = Double.parseDouble(loanInput);
						break;
					}
					System.out.println("Invalid amount! Enter a positive number.");
				}

				account = new LoanAccount(lName, loanAmount);
				System.out.println("Loan account created successfully!");
				break;

			case 4:
				running = false;
				System.out.println("Thank you for using Bank App");
				continue;

			default:
				System.out.println("Invalid choice");
				continue;
			}

			// Operations menu
			boolean run = true;
			while (run) {
				System.out.println("\nSelect Operation");
				System.out.println("1. Deposit");
				System.out.println("2. Withdraw");
				System.out.println("3. Check Balance");
				System.out.println("4. Back to account selection");

				int operationChoice = Integer.parseInt(scanner.nextLine().trim());

				switch (operationChoice) {
				case 1:
					double depositAmount;
					while (true) {
						System.out.println("Enter amount to deposit:");
						String depositInput = scanner.nextLine();
						
						if (amountPattern.matcher(depositInput).matches()) {
							depositAmount = Double.parseDouble(depositInput);
							break;
						}
						System.out.println("Invalid amount! Enter a positive number.");
					}
					account.deposit(depositAmount);
					break;

				case 2:
					double withdrawAmount;
					while (true) {
						System.out.println("Enter amount to withdraw:");
						String withdrawInput = scanner.nextLine();
						
						if (amountPattern.matcher(withdrawInput).matches()) {
							withdrawAmount = Double.parseDouble(withdrawInput);
							break;
						}
						System.out.println("Invalid amount! Enter a positive number.");
					}
					account.withdraw(withdrawAmount);
					break;

				case 3:
					account.checkBalance();
					break;

				case 4:
					run = false;
					break;

				default:
					System.out.println("Invalid choice");
					break;
				}
			}
		}

		scanner.close();
	}
}