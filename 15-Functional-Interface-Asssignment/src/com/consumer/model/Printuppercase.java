package com.consumer.model;

import java.util.Scanner;
import java.util.function.Consumer;

public class Printuppercase {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Consumer<String> toUpper = str -> System.out.println(str.toUpperCase());
		
		System.out.println("Enter the string");
		String str = scanner.nextLine();
		
		toUpper.accept(str);
		
			
		}
	}


