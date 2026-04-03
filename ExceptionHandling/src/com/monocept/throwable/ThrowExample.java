package com.monocept.throwable;

import java.util.Scanner;

public class ThrowExample {
	public static void main(String[] args) {
		
	   Scanner scanner = new Scanner(System.in);
	   
	   
	   System.out.println("Enter the amount");
	   double amount = scanner.nextDouble();
	   
	   if(amount < 0) {
		   
		   throw new IllegalArgumentException("Amount must be positive");
	   }
	   System.out.println("Amount "+amount);
	   
	}

}
