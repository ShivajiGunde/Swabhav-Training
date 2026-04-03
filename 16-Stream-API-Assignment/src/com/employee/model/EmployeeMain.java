package com.employee.model;

import java.util.*;
import java.util.stream.*;

public class EmployeeMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();

		try {
			System.out.print("Enter number of employees: ");
			int n = sc.nextInt();

			for (int i = 0; i < n; i++) {
				try {
					System.out.println("\nEnter details of employee " + (i + 1));

					System.out.print("ID: ");
					int id = sc.nextInt();

					sc.nextLine(); 

					System.out.print("Name: ");
					String name = sc.nextLine();

					System.out.print("Department: ");
					String dept = sc.nextLine();

					System.out.print("Salary: ");
					double salary = sc.nextDouble();

					System.out.print("Experience (years): ");
					int exp = sc.nextInt();

					System.out.print("Active Status (true/false): ");
					boolean status = sc.nextBoolean();

					employees.add(new Employee(id, name, dept, salary, exp, status));

				} catch (InputMismatchException e) {
					System.out.println("Invalid input! Please enter correct data.");
					sc.nextLine(); 
					i--; // retry same employee
				}
			}

			int choice;
			do {
				System.out.println("\n===== MENU =====");
				System.out.println("1. Get all active employees");
				System.out.println("2. Employees with salary above threshold");
				System.out.println("3. Count employees department-wise");
				System.out.println("4. Highest paid employee");
				System.out.println("5. Names sorted by salary descending");
				System.out.println("6. Group employees by department");
				System.out.println("7. Average salary department-wise");
				System.out.println("8. Exit");
				System.out.print("Enter your choice: ");

				choice = sc.nextInt();

				switch (choice) {

				case 1:
					System.out.println("\nActive Employees:");
					employees.stream().filter(Employee::getActiveStatus).forEach(System.out::println);
					break;

				case 2:
					try {
						System.out.print("Enter salary threshold: ");
						double threshold = sc.nextDouble();

						employees.stream().filter(e -> e.getSalary() > threshold).forEach(System.out::println);
					} catch (InputMismatchException e) {
						System.out.println("Invalid salary input!");
						sc.nextLine();
					}
					break;

				case 3:
					Map<String, Long> deptCount = employees.stream()
							.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

					deptCount.forEach((dept, count) -> System.out.println(dept + " : " + count));
					break;

				case 4:
					employees.stream().max(Comparator.comparingDouble(Employee::getSalary))
							.ifPresent(System.out::println);
					break;

				case 5:
					employees.stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
							.map(Employee::getName).forEach(System.out::println);
					break;

				case 6:
					Map<String, List<Employee>> grouped = employees.stream()
							.collect(Collectors.groupingBy(Employee::getDepartment));

					grouped.forEach((dept, empList) -> {
						System.out.println(dept + ":");
						empList.forEach(System.out::println);
					});
					break;

				case 7:
					Map<String, Double> avgSalary = employees.stream().collect(Collectors
							.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

					avgSalary.forEach((dept, avg) -> System.out.println(dept + " : " + avg));
					break;

				case 8:
					System.out.println("Exiting program...");
					break;

				default:
					System.out.println("Invalid choice.");
				}

			} while (choice != 8);

		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}