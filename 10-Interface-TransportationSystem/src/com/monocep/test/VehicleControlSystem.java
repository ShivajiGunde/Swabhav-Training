package com.monocep.test;

import java.util.Scanner;

import com.monocep.model.Bike;
import com.monocep.model.Car;
import com.monocep.model.Truck;
import com.monocep.model.VehicleControl;

public class VehicleControlSystem {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		 boolean running = true;

	        VehicleControl vehicle = null;

	        while (running) {
	            System.out.println("\nSelect Vehicle Type:");
	            System.out.println("1. Car");
	            System.out.println("2. Bike");
	            System.out.println("3. Truck");
	            System.out.println("4. Exit");

	            int choice = Integer.parseInt(scanner.nextLine().trim());

	            switch (choice) {
	                case 1:
	                    vehicle = new Car();
	                    System.out.println("Car selected.");
	                    break;
	                case 2:
	                    vehicle = new Bike();
	                    System.out.println("Bike selected.");
	                    break;
	                case 3:
	                    vehicle = new Truck();
	                    System.out.println("Truck selected.");
	                    break;
	                case 4:
	                    running = false;
	                    System.out.println("Exiting Vehicle System. Goodbye!");
	                    continue;
	                default:
	                    System.out.println("Invalid choice!");
	                    continue;
	            }

	            boolean operationRun = true;
	            while (operationRun) {
	                System.out.println("\nSelect Operation:");
	                System.out.println("1. Start");
	                System.out.println("2. Stop");
	                System.out.println("3. Change Gear");
	                System.out.println("4. Back to Vehicle Selection");

	                int opChoice = Integer.parseInt(scanner.nextLine().trim());

	                switch (opChoice) {
	                    case 1:
	                        vehicle.start();
	                        break;
	                    case 2:
	                        vehicle.stop();
	                        break;
	                    case 3:
	                        System.out.println("Enter gear number:");
	                        int gear = Integer.parseInt(scanner.nextLine().trim());
	                        vehicle.changeGear(gear);
	                        break;
	                    case 4:
	                        operationRun = false;
	                        break;
	                    default:
	                        System.out.println("Invalid operation!");
	                        break;
	                }
	            }
	        }

	        scanner.close();
	    }
	
	}


