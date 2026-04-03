package com.string.email;

import java.util.Scanner;

public class EmailAnalyser {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the user email");
		String email = scanner.nextLine().trim();

		if (!email.contains("@")) {
			System.out.println("Invalid email.email not contains @.");
			scanner.close();
			return;
		}

		int atIndexOf = email.indexOf("@");
		String username = email.substring(0, atIndexOf);

		String domain = email.substring(atIndexOf + 1);

		boolean isGmail = domain.equalsIgnoreCase("gmail.com");

		int totalCharacters = username.length();

		String lower = email.toLowerCase();

		boolean containsDigits = username.matches(".*\\d.*");

		String modifiedUsername = username.replace('.', '_');

		System.out.println("Email: " + email);
		System.out.println("domain: " + domain);
		System.out.println("UserName: " + username);
		System.out.println("totalCharacters: " + totalCharacters);
		System.out.println("IsDigits: " + (containsDigits ? "yes" : "no"));
		System.out.println("Modified Usename: " + modifiedUsername);

	}
}
