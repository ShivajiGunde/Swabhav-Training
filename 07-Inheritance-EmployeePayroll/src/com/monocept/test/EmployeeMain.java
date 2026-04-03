package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.ContractEmployee;
import com.monocept.model.Employee;
import com.monocept.model.FullTimeEmployee;
import com.monocept.model.PartTimeEmployee;

public class EmployeeMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of employees");
		int n = scanner.nextInt();

		Employee[] employees = new Employee[n];

		for (int i = 0; i < n; i++) {				
			
			System.out.println("\nEnter details for employees " +(i + 1));
			System.out.println("Employee type: (1-FullTime,2-PartTime,3-Constract");
			int type = scanner.nextInt();

			System.out.println("Enter Employee name: ");
			String name = scanner.nextLine();
			
			scanner.next();

			switch (type) {
			case 1: 
				System.out.print("Enter Basic salary: ");
				double basic = scanner.nextDouble();

				System.out.print("Enter HRA: ");
				double hra = scanner.nextDouble();

				System.out.print("Enter DA: ");
				double da = scanner.nextDouble();

				employees[i] = new FullTimeEmployee(name, basic, hra, da);
				break;

			case 2: 
				System.out.print("Enter Hours worked: ");
				int hours = scanner.nextInt();

				System.out.print("Enter Hourly rate: ");
				double rate = scanner.nextDouble();

				employees[i] = new PartTimeEmployee(name, hours, rate);
				break;

			case 3: 
				System.out.print("Enter Fixed amount: ");
				double fixed = scanner.nextDouble();

				System.out.print("Enter Tax: ");
				double tax = scanner.nextDouble();

				employees[i] = new ContractEmployee(name, fixed, tax);
				break;

			default:
				System.out.println("Invalid type skip employees.");
				i--;
				continue;
			}
		}

		System.out.println("--- Employee Payslips ---");

		for (Employee emp : employees) {
			emp.calculateSalary();
			emp.displayEmployee();
		}

		scanner.close();
	}

}