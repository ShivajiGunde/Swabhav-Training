package com.monocept.model;

public class NumberRepeating {

	public static void main(String[] args) {

		int[] arr = { 10, 32, 12, 10, 20, 30 };

		int target = 10;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				count++;
			}
		}
		System.out.println("Numbers " + target + " Appears: " + count);

	}
}
