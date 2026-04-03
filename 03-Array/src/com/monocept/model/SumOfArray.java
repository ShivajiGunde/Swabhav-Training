package com.monocept.model;

public class SumOfArray {
	
	public static void main(String[] args) {
		
		int[] numbers = {10,23,12,23,87,35};
		
		int sum = 0;
		
		for(int i = 0 ; i < numbers.length;i++) {
			
			sum += numbers[i];
		}
		System.out.println("Sum of the Array "+sum);
	}

}
