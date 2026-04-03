package com.monocept.bankmain;

import java.util.Scanner;

import com.monocept.model.Account;
import com.monocept.model.CurrentAccount;
import com.monocept.model.SavingAccount;

public class BankApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		boolean running = true;

		Account account = null;

		while (running) {

			System.out.println("Enter your choice");

			System.out.println(" 1.Saving Account");
			System.out.println(" 2.Current Account");
			System.out.println(" 3.deposit");
			System.out.println(" 4.withdraw");
			System.out.println(" 5.DisplayDetails");
			System.out.println(" 6.exit");

			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter Account Holder Name:");
				String sName = scanner.nextLine();

				System.out.println("Enter initial balance");
				double sBalance = scanner.nextDouble();
				 
				System.out.println("Enter minimum balance");
				double minBal = scanner.nextDouble();
				sBalance += minBal;

				System.out.println("Saving account created succesfully");
				account = new SavingAccount(sName, sBalance, minBal);
				break;

			case 2:
				System.out.println("Enter Account Holder Name:");
				String cName = scanner.nextLine();

				System.out.println("Enter initial balance");
				double cBalance = scanner.nextDouble();

				System.out.println("Enter overdraftLimit");
				double overdraft = scanner.nextDouble();

				System.out.println("current account created succesfully");
				account = new CurrentAccount(cName, cBalance, overdraft);
				break;
			case 3:

				if (account == null) {
					System.out.println("Please create an account first");
					break;
				}
				System.out.println("Enter Deposit Amount:");
				double depositAmount = scanner.nextDouble();
				account.deposit(depositAmount);
				break;
			case 4:
				if (account == null) {
					System.out.println("Please create an account first!");
					break;
				}
				System.out.println("Enter Withdrawal Amount:");
				double withdrawAmount = scanner.nextDouble();
				account.withdraw(withdrawAmount);
				break;

			case 5:
				if (account == null) {
					System.out.println("No account found!");
				} else {
					account.displayDetails();
				}
				break;
			case 6:
				running = false;
				System.out.println("Thank You for Using Bank App");
				break;

			default:
				System.out.println("Invalid choice");
			}

		}

		scanner.close();

	}

}
