package com.vehicle.test;

import java.util.Scanner;

import com.vehicle.model.VehicleManager;

public class VehicleRegistrationSystem {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of vehicles");
		int n = scanner.nextInt();
		
		scanner.nextLine();
		
		VehicleManager vehicleManager = new VehicleManager(n);
		
		vehicleManager.createVehicle();
		vehicleManager.display();
		vehicleManager.closeScanner();
	}

}
