package com.string.ipvalidator;

import java.util.Scanner;

public class IPvValidation {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the IPv4 address");
		String ip = scanner.nextLine();

		if (isValidIPv4(ip)) {
			System.out.println("Valid IPv4 Address");
		}
		else {
			System.out.println("Invalid IPv4 Address");
		}
	}

	public static  boolean isValidIPv4(String ip) {

		String[] parts = ip.split("\\.");

		if (parts.length != 4)
			return false;

		for (String part : parts) {

			if (part.length() == 0)
				return false;

			int num = Integer.parseInt(part);

			if (num < 0 || num > 255)
				return false;

			if (part.length() > 1 && part.charAt(0) == '0')
				return false;
		}

		return true;
	}

}
