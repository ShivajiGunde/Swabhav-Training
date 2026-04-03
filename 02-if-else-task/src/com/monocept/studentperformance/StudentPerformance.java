package com.monocept.studentperformance;

import java.util.Scanner;

public class StudentPerformance {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of students: ");
		int n = sc.nextInt();

		int[][] marks = new int[n][5];
		int distinctionCount = 0;
		double[] subjectTotal = new double[5];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter marks for Student " + (i + 1) + ":");
			for (int j = 0; j < 5; j++) {
				marks[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {

			int total = 0;
			boolean fail = false;

			for (int j = 0; j < 5; j++) {

				if (marks[i][j] < 35) {
					fail = true;
				}

				total += marks[i][j];
				subjectTotal[j] += marks[i][j];
			}

			double average = total / 5.0;

			System.out.print("\nStudent " + (i + 1) + ": ");

			if (fail) {
				System.out.println("Fail");
			} else if (average >= 85) {
				System.out.println("Distinction");
				distinctionCount++;
			} else if (average >= 60) {
				System.out.println("First Class");
			} else if (average >= 50) {
				System.out.println("Second Class");
			} else {
				System.out.println("Pass");
			}
		}

		System.out.println("Total Distinctions: " + distinctionCount);

		double highestAverage = 0;
		int highestSubject = 0;

		for (int j = 0; j < 5; j++) {
			double avg = subjectTotal[j] / n;

			if (avg > highestAverage) {
				highestAverage = avg;
				highestSubject = j;
			}
		}

		System.out.printf("Subject %d has the highest average: %.2f\n", (highestSubject + 1), highestAverage);

		sc.close();
	}
}
