package com.hospital.model;

import java.util.Scanner;

public class StaffManager {

	private Staff[] staff;
	private Scanner scanner;

	public StaffManager(int n) {
		staff = new Staff[n];
		scanner = new Scanner(System.in);
	}

	public void createStaff() {
		for (int i = 0; i < staff.length; i++) {
			System.out.println("\nEnter details for Staff " + (i + 1));

			int type = 0;
			while (true) { // Staff type validation
				System.out.print("Enter Staff Type (1-Doctor, 2-Nurse): ");
				type = scanner.nextInt();
				scanner.nextLine();

				if (type == 1 || type == 2)
					break;
				System.out.println("Invalid type! Must be 1 or 2.");
			}

			String name ="";
			while (true) {
				System.out.print("Enter Name: ");
				 name = scanner.nextLine();

				if (!name.isEmpty() && name.matches("[a-zA-Z ]+"))
					break;
				throw new IllegalArgumentException("Invalid name! Letters and spaces only.");
			}

			String department="";
			while (true) {
				System.out.print("Enter Department (uppercase letters): ");
				 department = scanner.nextLine();

				if (!department.isEmpty() && department.matches("[A-Z]+"))
					break;
				throw new IllegalArgumentException("Invalid department! Must be uppercase letters.");
			}

			if (type == 1) {
				String specialization ="";
				while (true) {
					System.out.print("Enter Specialization: ");
					 specialization = scanner.nextLine();

					if (!specialization.isEmpty())
						break;
					System.out.println("Specialization cannot be empty.");
				}
				staff[i] = new Doctor(name, department, specialization);

			} else { // Nurse
				String shift = "";
				while (true) {
					System.out.print("Enter Shift (Morning/Night): ");
					shift = scanner.nextLine();

					if (shift.matches("^(Morning|Night)$"))
						break;
					throw new IllegalArgumentException("Shift must be Morning or Night!");
				}
				staff[i] = new Nurse(name, department, shift);
			}

			System.out.println("Staff member added successfully!");
		}
	}

	// Method 2: Operations menu
	public void operateStaff() {
		for (int i = 0; i < staff.length; i++) {
			Staff s = staff[i];
			boolean running = true;

			while (running) {
				System.out.println("\nOperations for " + s.name);
				System.out.println("1. Display Staff Info");
				System.out.println("2. Update Department");
				System.out.println("3. Next Staff");

				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					s.display();
					break;

				case 2:
					System.out.print("Enter new Department (uppercase letters): ");
					String dept = scanner.nextLine();

					if (!dept.isEmpty() && dept.matches("[A-Z]+")) {
						s.department = dept;
						System.out.println("Department updated successfully.");
					} else {
						System.out.println("Invalid department!");
					}
					break;

				case 3:
					running = false;
					break;

				default:
					System.out.println("Invalid choice!");
				}
			}
		}
	}

	public void displayAllStaff() {
		System.out.println("\n===== All Staff Details =====");
		for (Staff s : staff) {
			if (s != null)
				s.display();
			System.out.println("---------------------------");
		}
	}

	public void closeScanner() {
		scanner.close();
	}
}