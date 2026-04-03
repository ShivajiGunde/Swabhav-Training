package com.monocept.model;

public class MaximumOfArray {
	public static void main(String[] args) {

		int[] numbers = { 23, 46, 21, 98, 76, 90 };

		int max = numbers[0];

		for (int i = 1; i < numbers.length; i++) {

			if (numbers[i] > max) {

				max = numbers[i];
			}

		}
		System.out.println("Maximum of the Array " + max);

	}

}
