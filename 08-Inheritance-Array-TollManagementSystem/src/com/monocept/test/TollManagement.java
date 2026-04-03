package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.Car;
import com.monocept.model.MotorCycle;
import com.monocept.model.Truck;
import com.monocept.model.Vehicle;

public class TollManagement {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("enter the number of vehicles");
		int n = scanner.nextInt();

		scanner.nextLine();

		Vehicle[] vehicle = new Vehicle[n];

		int i = 0;
		while (i < n) {

			System.out.println("Enter the vehicle " + (i + 1));
			
			System.out.println("Enter the vehicle number");
			String vehicleNumber = scanner.nextLine();
			

			// Validation not working 
			if (vehicleNumber == null || vehicleNumber.trim().isEmpty()) {

				System.out.println("Vehicle number cannot be empty");
				continue;
			}


			System.out.println("Select Vehicle Type:");
			System.out.println("1. Car");
			System.out.println("2. Truck");
			System.out.println("3. Motorcycle");

			int choice = scanner.nextInt();
			
			scanner.nextLine();

			switch (choice) {

			case 1:
				vehicle[i] = new Car(vehicleNumber);
				break;
			case 2:
				System.out.println("Enter the weight");
				double weight = scanner.nextDouble();

				scanner.nextLine();

				vehicle[i] = new Truck(vehicleNumber, weight);
				break;
			case 3:

				vehicle[i] = new MotorCycle(vehicleNumber);
				break;

			default:
				System.out.println("Invalid choice");
				continue;
			}
			i++;
		}
		for (Vehicle v : vehicle) {

			System.out.println("====Dispay Vehicle Details===");
			double toll = v.calculateToll();
			System.out.println("Vehicle No: " + v.vehicleNumber + " Toll: " + toll);

			Vehicle.updateTotals(toll);
		}

		Vehicle.displayTotals();
		scanner.close();

	}

}
