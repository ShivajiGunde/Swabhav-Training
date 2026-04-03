package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.CreditCardPayment;
import com.monocept.model.Payment;
import com.monocept.model.UpiPayment;
import com.monocept.model.WalletPayment;

public class PaymentSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of payments");
		int n = scanner.nextInt();

		Payment[] payment = new Payment[n];

		int i = 0;
		while (i < n) {

			System.out.println("Enter the payment " + (i + 1));

			System.out.println("Enter the amount");
			double amount = scanner.nextDouble();

			if (amount <= 0) {
				System.out.println("Amount must be positive");
				continue;
			}
			System.out.println("Enter the payment type");
			System.out.println("1.CreditCard Payment");
			System.out.println("2.Upi Payment");
			System.out.println("3.Wallet Payment");

			int choice = scanner.nextInt();

			scanner.nextLine();

			switch (choice) {
			case 1:
				payment[i] = new CreditCardPayment(amount);
				break;
			case 2:
				payment[i] = new UpiPayment(amount);
				break;
			case 3:
				payment[i] = new WalletPayment(amount);

				break;
			default:
				System.out.println("Invalid choice");
				continue;
			}
			i++;
		}
		System.out.println("===Processing Payment=====");
		for (Payment p : payment) {

			p.processPayment();
		}
		scanner.close();
	}

}
