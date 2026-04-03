package com.monocept.task;

import java.util.Scanner;

public class SumOfDigitsOfNumber {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = scanner.nextInt();
		
		int sum = 0;
		while(number !=0) {
			
			int digit = number % 10;
			sum = sum + digit;
			number = number/10;
		}
		
		System.out.println("Sum of Digigts "+sum);
		scanner.close();
	}

}
