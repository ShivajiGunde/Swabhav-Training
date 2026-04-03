package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.EmergencyPatient;
import com.monocept.model.InPatient;
import com.monocept.model.OutPatient;
import com.monocept.model.Patient;

public class HospitalBillingSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of patients:");
		int n = scanner.nextInt();
		
		scanner.nextLine();
		
		Patient[] patient = new Patient[n];

		int i = 0;
		while (i < n) {

			System.out.println("Patient Details: " + (i + 1));
			
			System.out.println("Enter the Patient name:");
			String name = scanner.nextLine();
			
			//validation not working 
			if(name == null || name.trim().isEmpty()) {
				System.out.println("Patient name cannot be empty");
				continue;
				}

			System.out.println("Enter type of patient");
			System.out.println("1.InPatient");
			System.out.println("2.OutPatient");
			System.out.println("3.EmergencyPatient");

			int choice = scanner.nextInt();

			scanner.nextLine();

			switch (choice) {
			case 1:
				
				System.out.println("Enter the room Charges: ");
				double roomCharges = scanner.nextDouble();
				if(roomCharges <= 0) {
					System.out.println("room cgarges cannot be negative");
					continue;
				}
				
				patient[i] = new InPatient(name,roomCharges);
				break;
			case 2:
				System.out.println("Enter the consultant fee");
				double consultantFee = scanner.nextDouble();
				
				if (consultantFee <= 0) {
					System.out.println("ConsultantFee  cannot be negative");
					continue;
				}

				
				patient[i] = new OutPatient(name,consultantFee);
				break;
			case 3:
				System.out.println("Enter the surcharge");
				double surcharge = scanner.nextDouble();
				
				if(surcharge <= 0) {
					System.out.println("Surcharge cannot be negative");
					continue;
				}
				
				patient[i] = new EmergencyPatient(name,surcharge);
				break;
			default:
				System.out.println("Invalid choice");
				continue;
			}
			i++;

		}
		System.out.println("====BillGeneration===");
		for(Patient p: patient) {
			
			p.generateBill();
		}
		scanner.close();
	}

}
