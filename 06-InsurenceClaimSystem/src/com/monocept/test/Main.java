package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.InsurenceClaim;
import com.monocept.model.InsurenceClaim.ClaimStatus;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		

			
		System.out.println("Enter claim amount");
		double claimAmount = scanner.nextDouble();
		
		InsurenceClaim claim = new InsurenceClaim(claimAmount);

		boolean running = true;
		
		while(running) {
		System.out.println("Enter your choice");
		System.out.println(" 1.approve \n 2.reject \n 3.settled \n 4.claimDetails \n 5.exit");
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("Enter approved amount ");
			double approvedAmount = scanner.nextDouble();
			claim.approveClaim(approvedAmount);
			break;
			
		case 2:
			claim.rejectClaim();
		case 3:
			claim.settleClaim();
			
		case 4:
			claim.displayClaimDetails();
			break;
			
		case 5:
			System.out.println("Exit");
			running = false;
			break;
			
			default:
				System.out.println("Invalid choice");
			
	}

}
		scanner.close();
	}
}
