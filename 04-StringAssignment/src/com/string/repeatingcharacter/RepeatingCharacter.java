package com.string.repeatingcharacter;

import java.util.Scanner;

public class RepeatingCharacter {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the word");
		String str = scanner.nextLine();
		
		char firstNonRepeating = '\0'; 

		for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
		
		if(str.indexOf(c) == str.lastIndexOf(c)) {
			firstNonRepeating = c;
			break;
			
		}
		}if(firstNonRepeating != '\0') {
			
			System.out.println("first non repeating character "+firstNonRepeating);
		}else {
			System.out.println("No non Repeating character found");
		}
		}
	}


