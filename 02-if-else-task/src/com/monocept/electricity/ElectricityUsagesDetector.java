package com.monocept.electricity;

import java.util.Scanner;

public class ElectricityUsagesDetector {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[] usage = new int[30];
		
		 int highConsumptionCount = 0;
	        int totalUsage = 0;
	        boolean overloadWarning = false;

		
		System.out.println("Electricity usage for 30 days: ");		
		for(int i = 0; i < 30; i++) {
			
			System.out.println("Days: "+(i+1));
			usage[i] = scanner.nextInt();
			
			if(usage[i] > 500) {
				System.out.println("High Consuption");
			}else if(usage[i] < 100) {
				System.out.println("Low user alert");
			}else {
				System.out.println("Normal Use");
			}
			
			if (i >= 2) {
                if (usage[i] > 500 &&
                    usage[i - 1] > 500 &&
                    usage[i - 2] > 500) {

                    overloadWarning = true;
                }
			
		}
			
	}
        double averageUsage = (double) totalUsage / 30;
        System.out.println("\n===== Monthly Report =====");
        System.out.println("High Consumption Days: " + highConsumptionCount);
        System.out.println("Monthly Average Usage: " + averageUsage);

        if (overloadWarning) {
            System.out.println("Overload Warning: YES (3 consecutive high usage days detected)");
        } else {
            System.out.println("Overload Warning: NO");
        }

        if (averageUsage > 400) {
            System.out.println("Month Status: Heavy Month");
        } else {
            System.out.println("Month Status: Normal Month");
        }

        scanner.close();
    }
	}


