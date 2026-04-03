package com.string.frequencycounter;

import java.util.Scanner;

public class WordFrequencyCounter {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the sentence");
		String str = scanner.nextLine();

		String toLower = str.toLowerCase();

		// split in words
		String[] words = str.split(" ");

		for (int i = 0; i < words.length; i++) {
			int count = 0;
			for (int j = 0; j < words.length; j++) {
				if (words[i].equals(words[j])) {
					count++;
				}
			}
			System.out.println("frequency: " + words[i] + " " + count);

		}

	}

}
