package com.monocept.division;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionException {

	public static void division(int a, int b) {
		try {
			int result = a / b;

			System.out.println("Result:" + result);
		} catch (ArithmeticException e) {

			System.out.println("cannot divide by zero");
		}

	}
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter number 1");
			int number1 = scanner.nextInt();

			System.out.println("Enter number 2");
			int number2 = scanner.nextInt();

			division(number1, number2);

		} catch (InputMismatchException e) {

			System.out.println("error: Invalid Input. Enter numeric value" + e.getMessage());
		} finally {

			scanner.close();
		}

	}

}
