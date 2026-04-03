package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.Employee;
import com.monocept.model.FullTimeEmployee;
import com.monocept.model.Intern;
import com.monocept.model.PartTimeEmployee;

public class EmployeePayroll {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of employees");
		int n = scanner.nextInt();
		
		Employee[] employees = new Employee[n];
		
		int i = 0;

		while (i < n) {

			System.out.println("\nEnter details of employees: " + (i + 1));
			
			System.out.println("Enter Employee Id:");
			int empId = scanner.nextInt();
			scanner.nextLine();
			
			if (empId <= 0) {
				System.out.println("EmployeeId cannot be negative");
				continue;
			}

			System.out.println("Enter employee name");
			String empName = scanner.nextLine().trim();	
			
			if(empName.isEmpty()) {
				System.out.println("Employee name cannot be empty");
				continue;
			}
				
	        System.out.println("Select Employee Type:");

			System.out.println(" 1.FullTime Employee");
			System.out.println(" 2.PartTime employee");
			System.out.println(" 3.Intern");
		
			int choice = scanner.nextInt();
			
			
			switch (choice) {

			case 1:
				
				System.out.println("Enter basic salary");
				double bSal = scanner.nextDouble();

				System.out.println("Enter hra");
				double hraSal = scanner.nextDouble();
				
				System.out.println("Enter da");
				Double daSal = scanner.nextDouble();
				
				employees[i] = new FullTimeEmployee(empId, empName, bSal,hraSal,daSal);
				break;

			case 2:
				System.out.println("Enter hoursWorked:");
				int hWorked = scanner.nextInt();

				System.out.println("Enter hourlyRate");
				double hRate = scanner.nextDouble();

				employees[i] = new PartTimeEmployee(empId, empName,hWorked,hRate);
				break;
				
			case 3:

				System.out.println("Enter fixed Amount:");
				double fixdAmount = scanner.nextDouble();
				
				employees[i] = new Intern(empId,empName,fixdAmount);
				break;

			default:
				System.out.println("Invalid choice");
				continue;
			}
			i++;

		}
		
		System.out.println("===Display Employee Details======");
		for(Employee emp : employees) {
			emp.displayEmployeeDetails();
			scanner.nextLine();
			
			System.out.println("Total Employees  " + Employee.getTotalEmployees());

		}
		scanner.close();

	}

}
