package com.monocept.model;

import java.util.Scanner;

public class FactorialNumber {
	
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a number: ");
	        int num = scanner.nextInt();
	        
	       // int[] num = {10,20,30};
	        
	        int factorial = 1;
	        

	        for (int i = 1; i <= num; i++) {
	        	
	            factorial *= i; 
	       }

	        System.out.println("Factorial of " + num + " is " + factorial);

	        scanner.close();
	    }

}
