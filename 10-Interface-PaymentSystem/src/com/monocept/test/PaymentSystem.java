package com.monocept.test;

import java.awt.Container;
import java.util.Scanner;

import com.monocept.interfaces.CreditCardPayment;
import com.monocept.interfaces.DebitCardPayment;
import com.monocept.interfaces.Payment;
import com.monocept.interfaces.UpiPayment;

public class PaymentSystem {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the amount");
		double amount = scanner.nextDouble();
		
		if (amount <= 0) {
			System.out.println("amount cannot be negative");
			return;
		}	
				
		System.out.println("Enter the payment type:");
		System.out.println("1.CreditCard Payment");
		System.out.println("2.DebitCard Payment");
		System.out.println("3.UPI Payment");
		
		int choice = scanner.nextInt();
		
		Payment payment;
		switch(choice) {
		case 1:
			
			 payment = new CreditCardPayment();
			 payment.processPayment(amount);
			
			break;
		case 2:
			payment = new DebitCardPayment();
			payment.processPayment(amount);
			break;
		case 3:
			payment  = new UpiPayment();
			payment.processPayment(amount);
			break;
			default:
				System.out.println("invalid choice");
		}
		
	   scanner.close();
	}

}
