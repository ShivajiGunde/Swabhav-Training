package com.monocept.finallyblock;

import java.util.Scanner;

public class CashWithdraw {

	public static void main(String[] args) {

		double balance = 10000;

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter amount to withdraw");
			double amount = scanner.nextDouble();

			if (amount > balance) {

				throw new ArithmeticException("Insufficient Fund.");
			} else {

				balance -= amount;
				System.out.println("Transaction successfu.");
				System.out.println("Balance: "+balance);
			}
		} finally {
			System.out.println("Transaction session ended.");
		}
	}

}
