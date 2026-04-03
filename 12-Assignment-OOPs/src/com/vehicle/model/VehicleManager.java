package com.vehicle.model;

import java.util.Scanner;

public class VehicleManager {

	private Scanner scanner;
	private Vehicle[] vehicle;
	
	public VehicleManager(int n) {
		
		scanner = new Scanner(System.in);
		vehicle = new Vehicle[n];
	}
	
	public void createVehicle() {

        for (int i = 0; i < vehicle.length; i++) {
            System.out.println("\nEnter details for vehicles " + (i + 1));

            int type = 0;
            while (true) {
                System.out.print("Select Vehicle Type (1-Car, 2-Bike): ");
                type = scanner.nextInt();
                scanner.nextLine();
                
                if (type == 1 || type == 2) break;
                System.out.println("Invalid type. Enter 1 or 2.");
            }

            String ownerName ="";;
            double baseUsageCharge=0.0;

            while (true) {
                try {
                   
                    System.out.print("Enter Owner Name: ");
                    ownerName = scanner.nextLine();

                    System.out.print("Enter baseUsageCharge: ");
                    baseUsageCharge = scanner.nextDouble();
                    scanner.nextLine();

                    if (type == 1) { 
                        System.out.print("Enter Seating capacity: ");
                        int seatingCapacity = scanner.nextInt();
                        scanner.nextLine();
                        
                        vehicle[i] = new Car(ownerName, baseUsageCharge, seatingCapacity);
                        
                    } else { 
                        System.out.print("Enter hasCarrier: ");
                        boolean hasCarrier = scanner.nextBoolean();
                        
                        vehicle[i] = new Bike( ownerName, baseUsageCharge, hasCarrier);
                    }
                    break; 
                    
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            System.out.println("Vehicle added successfully!");
        }
    }

    public void display() {
        System.out.println("\n===== Vehicle Details =====");
        for (Vehicle v : vehicle) {
             v.display();
        }
    }

    public void closeScanner() {
        scanner.close();
	
	
}
    
}
