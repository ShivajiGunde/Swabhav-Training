package com.monocept.insurenceportfolio;

import java.util.Scanner;

public class InsuranceRiskPortfolio {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of customer: ");
		int n = scanner.nextInt();

		int[] age = new int[n];
		int[] riskScores = new int[n];

		int highRisk = 0;
		int seniorRisk = 0;
		int veryHighRisk = 0;
		int normalRisk = 0;

		int totalRiskScore = 0;
		int highestRiskIndex = 0;

		for (int i = 0; i < n; i++) {

			System.out.println("Enter the ages of customers: ");
			age[i] = scanner.nextInt();

			System.out.println("Enter the risk scores of customers: ");
			riskScores[i] = scanner.nextInt();

			if (age[i] < 25 && riskScores[i] > 70) {
				System.out.println("High Risk Youth");
				highRisk++;

			} else if (age[i] >= 60) {
				System.out.println("Senior Risk");
				seniorRisk++;

			} else if (riskScores[i] >= 85) {
				System.out.println("Very high risk");
				veryHighRisk++;

			} else {
				System.out.println("Normal Risk");
				normalRisk++;

			}

			totalRiskScore += riskScores[i];
			
			if (riskScores[i] > riskScores[highestRiskIndex]) {
				highestRiskIndex = i;
			}
		}

		double averageRisk = (double) totalRiskScore / n;

		System.out.println("=====counts======");
		System.out.println("High Risk Count " + highRisk);
		System.out.println("Senior Risk Count " + seniorRisk);
		System.out.println("Very High Risk Count " + veryHighRisk);
		System.out.println("Normal Risk Count " + normalRisk);

		scanner.close();
	}

}
