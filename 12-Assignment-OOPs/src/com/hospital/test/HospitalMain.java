package com.hospital.test;

import java.util.Scanner;

import com.hospital.model.StaffManager;

public class HospitalMain {
	
	public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter the number of staff");
	int n = scanner.nextInt();
	
	scanner.nextLine();
	
	StaffManager manager = new StaffManager(n);
	
	manager.createStaff();
	manager.operateStaff();
	manager.displayAllStaff();
  manager.closeScanner();
  scanner.close();
	
	}
	
}
