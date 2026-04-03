package com.monocept.model;

import java.util.Scanner;

public class ArrayDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the sze of array");
		int size = scanner.nextInt();

		int num[] = new int[size];

		if (size > 0) {
			for (int i = 0; i < size; i++) {

				num[i] = scanner.nextInt();

			}

			for (int i = 0; i < size; i++) {

				System.out.println(num[i] + " ");
			}
		} 
		else {

			System.out.println("Give positive number");
		}

	}
}
