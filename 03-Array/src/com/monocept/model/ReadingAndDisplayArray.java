package com.monocept.model;

import java.util.Scanner;

public class ReadingAndDisplayArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of array");
		int n = scanner.nextInt();

		int num[] = new int[n];

		if(n > 0) {
			for (int i = 0; i < n; i++) {

				num[i] = scanner.nextInt();

			}

			System.out.println("Display Array: ");
			for (int i = 0; i < n; i++) {

				System.out.println(num[i] + " ");
			}
		} 
		else {

			System.out.println("Give positive number");
		}

	}
}
