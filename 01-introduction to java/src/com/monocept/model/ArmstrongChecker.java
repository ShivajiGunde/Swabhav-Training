package com.monocept.model;

import java.util.Scanner;

public class ArmstrongChecker {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		
		System.out.println("Enter the number");
		int number = scanner.nextInt();

//		int original = number;
//		int sum = 0;
//
//		while (number != 0) {
//			int digit = number % 10;
//
//			sum += digit * digit * digit;
//
//			number /= 10;
//		}
//
//		if (sum == original) {
//
//			System.out.println("Armstrong number");
//		} else {
//			System.out.println("Not Armstrong");
//		}
		
		int original = number;
		int sum = 0;
		int digit=0;
		for(int temp = number; temp!=0;temp /=10) {
			digit++;
		}
		for(int temp = number; temp!=0;temp /=10) {
             int digits = temp%10;
             sum += digit*digit*digit;
             
             if(sum == original) {
            	 System.out.println("Armstrong");
             }else {
            	System.out.println("Not armstrong"); 
             }
		scanner.close();
		
		
		}
	}
}
