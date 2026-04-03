package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.Bike;
import com.monocept.model.Car;
import com.monocept.model.Vehicle;

public class VehicleSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of vehicles");
		int n = scanner.nextInt();

		scanner.nextLine();

		Vehicle[] vehicle = new Vehicle[n];

		int i = 0;
		while (i < n) {

			System.out.println("Enter the vehicle type:" + (i + 1));

			System.out.println("1.Car");
			System.out.println("2.Bike");

			int type = scanner.nextInt();

			scanner.nextLine();

			switch (type) {
			case 1:
				vehicle[i] = new Car();
				break;
			case 2:
				vehicle[i] = new Bike();
				break;
			default:
				System.out.println("Invalid choice");
				continue;
			}
			i++;
		}
			for (Vehicle v : vehicle) {
				v.start();
				v.stop();
				v.fuelType();

			}
			scanner.close();
		}

	}

