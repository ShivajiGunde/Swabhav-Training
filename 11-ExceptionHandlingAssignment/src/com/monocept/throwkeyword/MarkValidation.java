package com.monocept.throwkeyword;

import java.util.Scanner;

public class MarkValidation {
	
	public static void validateMarks(int marks) {
		if(marks < 0 || marks > 100) {
			
			throw new IllegalArgumentException("");
		}else {
			System.out.println("Valid Marks");
		}
		
		
	}public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the marks");
		int marks = scanner.nextInt();
		
		validateMarks(marks);
	}

}
