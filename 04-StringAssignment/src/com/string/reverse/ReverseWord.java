package com.string.reverse;

import java.util.Scanner;

public class ReverseWord {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the sentence");
		String str = scanner.nextLine();

		String[] words = str.split(" ");

		String result = "";

		for (String word : words) {

			String reverse = "";

			for (int i = word.length() - 1; i >= 0; i--) {

				reverse += word.charAt(i);

			}
			result = result + reverse + " ";
		}
		System.out.println("Reverse: " + result);

	}

}
