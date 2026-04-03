package com.monocept.smartloan;

import java.util.Scanner;

public class LoanEligibityChecker {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("enter the number of applicants");
		int n = scanner.nextInt();

		int[] creditScores = new int[n];
		int[] monthlyIncomes = new int[n];
		int[] existingLoans = new int[n];

		int totalApprovals = 0;
		int totalRejections = 0;

		int bestApplicantIndex = -1;
		int bestScore = -1;

		for (int i = 0; i < n; i++) {

			System.out.println("Enter the creditScore");
			creditScores[i] = scanner.nextInt();

			System.out.println("Enter the monthlyIncomes");
			monthlyIncomes[i] = scanner.nextInt();

			System.out.println("Enter the existingLoans");
			existingLoans[i] = scanner.nextInt();

			if (creditScores[i] < 600 && monthlyIncomes[i] < 25000 && existingLoans[i] >= 3) {

				System.out.println("Load application Rejected ");
				totalRejections++;
			} else if (creditScores[i] >= 800 && monthlyIncomes[i] > 100000) {
				System.out.println("Instant approval ");
				totalApprovals++;

			} else {
				System.out.println("Standard Review ");
			}
			int profileScore = creditScores[i] + monthlyIncomes[i] - (existingLoans[i] * 1000);

			if (profileScore > bestScore) {
				bestScore = profileScore;
				bestApplicantIndex = i;
			}
			System.out.println("===== Summary =====");
			System.out.println("Total Approvals: " + totalApprovals);
			System.out.println("Total Rejections: " + totalRejections);
			
			
			if (bestApplicantIndex != -1) {
	            System.out.println("Best Approval Profile: Applicant " 
	                                + (bestApplicantIndex + 1));
	        } else {
	            System.out.println("No approved applicants.");
	        }

	        scanner.close();

		}

	}

}
