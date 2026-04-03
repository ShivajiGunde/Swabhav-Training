package com.student.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.student.model.RegularStudent;
import com.student.model.ScholarshipStudent;
import com.student.model.Student;

public class StudentProfileSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Enter number of students: ");
			int n = sc.nextInt();
			sc.nextLine();

			if (n <= 0) {
				throw new IllegalArgumentException("students must be greater than 0");
			}

			Student[] students = new Student[n];

			for (int i = 0; i < n; i++) {

				try {
					System.out.println("\nEnter details for Student " + (i + 1));

					System.out.print("Enter Student Type (1-Regular, 2-Scholarship): ");
					int type = sc.nextInt();
					sc.nextLine();

					if (type != 1 && type != 2) {

						throw new IllegalArgumentException("Invalid Student Type! Must be 1 or 2.");

					}
					System.out.print("Enter ID: ");
					long id = sc.nextInt();
					sc.nextLine();

					if (id <= 0) {
						throw new IllegalArgumentException("Id must be 0-9 only.");
					}

					System.out.print("Enter Name: ");
					String name = sc.nextLine();

					if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
						throw new IllegalArgumentException(
								"Name cannot be empty and must contain only letters and spaces!");
					}

					System.out.print("Enter Course: ");
					String course = sc.nextLine();

					if (course.isEmpty() || !course.matches("[A-Z]+")) {
						throw new IllegalArgumentException("course cannot be empty. Course must be uppercase");
					}

					if (type == 1) {
						System.out.print("Enter Attendance: ");
						String attendance = sc.nextLine();

						if (attendance.isEmpty() || !attendance.matches("^(Present|Absent)$")) {
							throw new IllegalArgumentException("Attendance cannot be empty!");
						}
						students[i] = new RegularStudent(id, name, course, attendance);

					} else if (type == 2) {
						System.out.print("Enter Scholarship Amount: ");
						double amount = sc.nextDouble();

						if (amount <= 0) {
							throw new IllegalArgumentException("amount muts  be positive:");
						}
						students[i] = new ScholarshipStudent(id, name, course, amount);
					} else {
						System.out.println("Invalid student type!");
						i--;
					}

				} catch (InputMismatchException e) {
					System.out.println("Invalid input! Please enter correct data type.");
					sc.nextLine();
					i--;
				}
			}

			System.out.println("\n--- Student Details ---");

			for (Student s : students) {
				s.display();
			}

		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}