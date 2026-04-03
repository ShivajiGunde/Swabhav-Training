package com.monocept.model;

import java.util.Scanner;

public class CheckingPositiveNegativeOrZero {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number");
		int number = scanner.nextInt();

		if (number > 0) {

			System.out.println("Positive number");

		} else if (number < 0) {

			System.out.println("Negative number");

		} else {
			System.out.println("Zero number");
		}

	}

}
