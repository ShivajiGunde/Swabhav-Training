package com.string.product;

import java.util.Scanner;

public class ECommerseSystem {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

//		System.out.println("Enter the product code");
//		String code = scanner.nextLine();

		 String code = "ELC-TV-2023";

		String[] parts = code.split("-");

		String category = parts[0];
		String productName = parts[1];
		String year = parts[2];

		String toUpper = category.toUpperCase();

		boolean checkStart = productName.startsWith("TV");

		boolean endsWith = code.endsWith("2023");

		String modifiedCode = code.replace("-", " ");

		int firstHypenPosition = code.indexOf("-");

		System.out.println("==Printimg details===");
		System.out.println("Category: " + category);
		System.out.println("ProductName: " + productName);
		System.out.println("Year: " + year);
		System.out.println("Starts With: " + checkStart);
		System.out.println("Ends with: " + endsWith);
		System.out.println("Modified Code: " + modifiedCode);

	}

}
