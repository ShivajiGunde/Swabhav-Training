package com.function.model;

import java.util.Scanner;
import java.util.function.Function;

public class LengthCalculator {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Function<String, Integer> lengthFunction = s -> s.length();

		System.out.println("Enter the name1");
		String name1 = scanner.nextLine();

		System.out.println("Enter the name2");
		String name2 = scanner.nextLine();

		System.out.println("Enter the name3");
		String name3 = scanner.nextLine();

		System.out.println("Length Of name1: " + lengthFunction.apply(name1));
		System.out.println("Length Of name2: " + lengthFunction.apply(name2));
		System.out.println("Length Of name3: " + lengthFunction.apply(name3));


	}

}
