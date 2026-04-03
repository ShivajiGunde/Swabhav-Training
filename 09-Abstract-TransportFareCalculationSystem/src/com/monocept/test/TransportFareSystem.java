package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.Bus;
import com.monocept.model.Metro;
import com.monocept.model.Taxi;
import com.monocept.model.Transport;

public class TransportFareSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of vehicles");
		int n = scanner.nextInt();

		Transport[] transport = new Transport[n];

		scanner.nextLine();

		int i = 0;
		while (i < n) {

			System.out.println("Transport Details " + (i + 1));

			System.out.println("Enter route Id");
			int routeId = scanner.nextInt();

			if (routeId <= 0) {
				System.out.println("Route Id cannot be negative");
				continue;
			}

			System.out.println("Enter the base Fare");
			double baseFare = scanner.nextDouble();

			if (baseFare <= 0) {

				System.out.println("base fare cannot be negative");
				continue;
			}

			scanner.nextLine();

			System.out.println("Enter the transport type");
			System.out.println("1.Bus");
			System.out.println("2.Metro");
			System.out.println("3.Taxi");

			int choice = scanner.nextInt();

			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter distance");
				int distance = scanner.nextInt();

				if (distance <= 0) {
					System.out.println("Distance cannot be negative");
					continue;
				}

				transport[i] = new Bus(routeId, baseFare, distance);
				break;
			case 2:
				System.out.println("Enter number of stations");
				int nStations = scanner.nextInt();

				if (nStations <= 0) {
					System.out.println("number of stations cannot be negative");
					continue;
				}

				transport[i] = new Metro(routeId, baseFare, nStations);
				break;

			case 3:
				System.out.println("Enter distance ");
				int dist = scanner.nextInt();

				if (dist <= 0) {
					System.out.println("Distance cannot be negative");
					continue;
				}

				System.out.println("Enter time taken");
				int time = scanner.nextInt();

				if (time <= 0) {
					System.out.println("time cannot be negative");
					continue;
				}

				transport[i] = new Taxi(routeId, dist, time);
				break;

			default:
				System.out.println("Invalid choice");
				continue;
			}
			i++;

		}
		for (Transport t : transport) {

			t.printTicket();

		}
		scanner.close();
	}

}
