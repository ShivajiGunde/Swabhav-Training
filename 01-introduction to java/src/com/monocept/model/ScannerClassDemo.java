package com.monocept.model;

import java.util.Scanner;

public class ScannerClassDemo {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the name");
		String name = scanner.nextLine();
		
		System.out.println("enter the age");
		int age = scanner.nextInt();
		
		System.out.println("Name: "+name+ "Age: "+age);
		
	}

}
