package com.monocept.customexception;

import java.util.Scanner;

public class CustomMain extends InvalidAgeException {

	public CustomMain() {
	}

	public CustomMain(String message) {
		super(message);
	}

	public static void checkAge(int age) throws InvalidAgeException {

		if (age < 18) {

			throw new InvalidAgeException("Age cannot be less than 18: ");
		} else {
			System.out.println("Valid Age");
		}
	}

	public static void main(String[] args) throws InvalidAgeException {

		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter the age");
			int age = scanner.nextInt();

			checkAge(age);
		} catch (InvalidAgeException e) {
			System.out.println("Error: " + e.getMessage());
		}

		finally {
			scanner.close();
		}
	}

}
