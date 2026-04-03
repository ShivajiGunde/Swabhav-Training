
package com.monocept.model;

import java.util.Scanner;

public class ElectricityBill {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of units consumed:");
		int unitsConsumed = scanner.nextInt();
		
		double meterCharge = 75.0;
		double charge;
		
		if (unitsConsumed <= 100) {
		
			charge = unitsConsumed * 5;
		
		} else if (unitsConsumed < 250) {
		
			charge = unitsConsumed * 10;
		} else {
		
			charge = unitsConsumed * 20;
		}
		
		double totalWaterBill = charge + meterCharge;
		
		System.out.println("Total water bill: " + totalWaterBill);
		
		scanner.close();
		
	}
		}


