package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.CorporateClaim;
import com.monocept.model.InsurenceClaim;

public class InsurenceMain {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Select claim type");
		System.out.println("1. InsurenceClaim");
		System.out.println("2. CorporateClaim");

		System.out.println("Enter your choice");
		int choice = scanner.nextInt();
		
		scanner.nextLine();

		
		if (choice == 1) {

			System.out.println("Enter claim amount");
			double claimAmount = scanner.nextDouble();
			
			if(claimAmount < 0) {
				
				System.out.println("Claim amount cannot be negative");
			}else {

			InsurenceClaim insurenceClaim = new InsurenceClaim(claimAmount);
			
			System.out.println("Claim created succesfully");
            
			printClaimDetails(insurenceClaim);
			
			
			} 
		} else if(choice == 2) {
			
			System.out.println("Enter claim amount");
			double claimAmount = scanner.nextDouble();

			System.out.println("Enter Processing fee");
			double processingFee = scanner.nextDouble();
			
			if(claimAmount < 0 || processingFee < 0) {
				
				System.out.println("Amount and processing fee cannot be negative");
			}else {
			
			CorporateClaim corporateClaim = new CorporateClaim(claimAmount, processingFee);

			System.out.println("Corporate claim Created Successfully");
			printClaimDetails(corporateClaim);

			System.out.println("ProcessingFee: "+corporateClaim.getProcessingFee());
		}
			}else {
			
			System.out.println("Invalid choice");
		}
		scanner.close();

	}

	private static void printClaimDetails(InsurenceClaim insurenceClaim) {
		
				System.out.println("Claim ID: " + insurenceClaim.getClaimId());
		        System.out.println("Policy Number: " + insurenceClaim.getPolicyNumber());
		        System.out.println("Claim Amount: " + insurenceClaim.getClaimAmount());
		        System.out.println("Status: " + insurenceClaim.getStatus());
		        System.out.println("Approved Amount: " + insurenceClaim.getApprovedAmount());
				
	   }
	}


