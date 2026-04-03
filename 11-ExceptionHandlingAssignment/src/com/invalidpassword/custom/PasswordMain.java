package com.invalidpassword.custom;

import java.util.Scanner;

public class PasswordMain {

	public static void main(String[] args) throws InvalidPasswordException {

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter Password");
			String pwd = scanner.nextLine();

			PasswordValidator.checkPassword(pwd);

		} catch (InvalidPasswordException e) {
			
			System.out.println("Invalid Password: " + e.getMessage());

		} finally {
			
			scanner.close();
		}

	}

}
