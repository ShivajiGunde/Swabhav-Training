package com.monocept.task;

import java.util.Scanner;

public class PalindromCheker {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = scanner.nextInt();
		
		int originalNumber = number;
		int reversed = 0;
		
		while(number !=0) {
			
			int digit = number % 10;
			reversed = reversed * 10 + digit;
			number = number / 10;			
		}
		if(originalNumber == reversed) {
			
			System.out.println("Is Palindrom");
		}
		else {
			System.out.println("Not Palindrom");
		}
	}

}
