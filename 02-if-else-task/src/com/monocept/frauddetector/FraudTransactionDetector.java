package com.monocept.frauddetector;

import java.util.Scanner;

public class FraudTransactionDetector {
	
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of transactions: ");
	        int n = sc.nextInt();

	        double[] transactions = new double[n];

	        for (int i = 0; i < n; i++) {
	            System.out.print("Enter transaction " + (i + 1) + ": ");
	            transactions[i] = sc.nextDouble();
	        }

	        double total = 0;
	        boolean previousSuspicious = false;
	        boolean fraudDetected = false;

	        System.out.println("Suspicious Transactions at indices:");

	        for (int i = 0; i < n; i++) {

	            total = total + transactions[i];

	            if (transactions[i] > 50000) {
	                System.out.println("Index " + i + " (Amount: " + transactions[i] + ")");

	                if (previousSuspicious == true) {
	                    fraudDetected = true;
	                }

	                previousSuspicious = true;
	            } else {
	                previousSuspicious = false;
	            }
	        }

	        if (fraudDetected == true) {
	            System.out.println(" Potential Fraud Detected!");
	        } else {
	            System.out.println("No Fraud Pattern Detected.");
	        }

	        double average = total / n;
	        
	        System.out.println("Average Transaction Value: " + average);

	        if (average > 40000) {
	            System.out.println("High Value Account");
	        }

	        sc.close();
	    }
	}



