package com.string.password;

import java.util.Scanner;

public class PasswordValidator {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Entre password");
		String password = scanner.nextLine();

		password = password.replace(" ", "");

		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasDigit = false;

		for (int i = 0; i < password.length(); i++) {

			char ch = password.charAt(i);

			if (Character.isUpperCase(ch))
				hasUpper = true;
			if (Character.isLowerCase(ch))
				hasLower = true;
			if (Character.isDigit(ch))
				hasDigit = true;
		}
		if (password.length() >= 8) {
			System.out.println("Valid Password");
		} else {
			System.out.print("Invalid Password. resons: ");
			if (!hasUpper)
				System.out.print("Missing uppercase letter; ");
			if (!hasLower)
				System.out.print("Missing lowercase letter; ");
			if (!hasDigit)
				System.out.print("Missing digit; ");
			System.out.println();
		}
		scanner.close();
	}

}
