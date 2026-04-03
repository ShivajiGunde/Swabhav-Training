package com.monocept.nestedtrycatch;

import java.util.Scanner;

public class NestedTryCatchExamoke {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		 
		try{
			System.out.println("Enter the number-1");
		   int number1 = scanner.nextInt();
		
			System.out.println("Enter the number-2");
			int number2 = scanner.nextInt();
			
			int result = number1/number2;
			
			System.out.println("cannot devided by zero");
		
		   try {
			    int[] numbers = {10,20,30,40};
			
			System.out.println("Access 6th element "+numbers[5]);
			
			}catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.println("Array Index out of bounds ");
				}
		}
		catch(ArithmeticException e) {
			
			System.out.println("Cannot divide by zero ");
		}
	
    }
}
		