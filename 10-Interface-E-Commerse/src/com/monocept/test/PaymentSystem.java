package com.monocept.test;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.monocept.mode.Checkout;
import com.monocept.mode.CreditCard;
import com.monocept.mode.NetBanking;
import com.monocept.mode.PaymentGateway;
import com.monocept.mode.UPI;


public class PaymentSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pattern amountPattern = Pattern.compile("^\\d+(\\.\\d+)?$"); 
        Pattern cardPattern = Pattern.compile("^\\d{12,16}$"); 
        Pattern upiPattern = Pattern.compile("^[\\w.-]+@[\\w]+$");

        boolean running = true;

        while (running) {
            System.out.println("\nSelect Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("3. NetBanking");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(scanner.nextLine().trim());
            PaymentGateway payment = null;

            switch (choice) {
                case 1: 
                	
                    String cardNumber;
                    while (true) {
                        System.out.println("Enter Credit Card Number (12-16 digits):");
                        cardNumber = scanner.nextLine().trim();
                        
                        if (cardPattern.matcher(cardNumber).matches()) break;
                        System.out.println("Invalid card number! Enter 12-16 digits.");
                    }
                    payment = new CreditCard(cardNumber);
                    break;

                case 2: 
                    String upiId;
                    while (true) {
                        System.out.println("Enter UPI ID (like: user@bank):");
                        upiId = scanner.nextLine();
                       
                        if (upiPattern.matcher(upiId).matches()) break;
                        System.out.println("Invalid UPI ID! Use format user@bank.");
                    }
                    payment = new UPI(upiId);
                    break;

                case 3: // NetBanking
                    System.out.println("Enter Bank Name:");
                    String bankName = scanner.nextLine().trim();
                    payment = new NetBanking(bankName);
                    break;

                case 4:
                    running = false;
                    System.out.println("Thank you for using App");
                    continue;

                default:
                    System.out.println("Invalid choice");
                    continue;
            }

            Checkout checkout = new Checkout(payment);

            double amount;
            while (true) {
                System.out.println("Enter amount to pay:");
                String amountInput = scanner.nextLine().trim();
               
                if (amountPattern.matcher(amountInput).matches()) {
                    amount = Double.parseDouble(amountInput);
                    break;
                }
                System.out.println("Invalid amount! Enter a positive number.");
            }

            checkout.makePayment(amount);

            System.out.println("Do you want a refund? (yes/no)");
            String refundChoice = scanner.nextLine().trim();
           
            if (refundChoice.equalsIgnoreCase("yes")) {
                checkout.makeRefund(amount);
            }
        }

        scanner.close();
    }
}