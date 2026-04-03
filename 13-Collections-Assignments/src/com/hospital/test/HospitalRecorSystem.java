package com.hospital.test;

import java.util.Scanner;

import com.hospital.model.EmergencyPatient;
import com.hospital.model.GeneralPatient;
import com.hospital.model.HospitalManager;
import com.hospital.model.Patient;

public class HospitalRecorSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HospitalManager manager = new HospitalManager();

		try {
			System.out.print("Enter number of patients: ");
			int n = sc.nextInt();

			for (int i = 0; i < n; i++) {

				System.out.print("ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Name: ");
				String name = sc.nextLine();

				System.out.print("Age: ");
				int age = sc.nextInt();
				sc.nextLine();

				System.out.print("Doctor Name: ");
				String doctor = sc.nextLine();

				System.out.println("1. General  2. Emergency");
				int type = sc.nextInt();

				Patient p;

				if (type == 1)
					p = new GeneralPatient(id, name, age);
				else
					p = new EmergencyPatient(id, name, age);

				if (manager.addPatient(p, doctor)) {
					System.out.println("Patient added");
				} else {
					System.out.println("Duplicate patient!");
				}
			}

			System.out.println("\nNext Patient: ");
			System.out.println(manager.processNextPatient());

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}