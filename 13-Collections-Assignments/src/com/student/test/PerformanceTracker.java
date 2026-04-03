package com.student.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.student.model.PostgraduateStudent;
import com.student.model.Student;
import com.student.model.StudentTrackerManager;
import com.student.model.UndergraduateStudent;

public class PerformanceTracker {

	public static void main(String[] args) {

		StudentTrackerManager student = new StudentTrackerManager();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of students: ");
		int count = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < count; i++) {

			System.out.println("\nEnter details for Student " + (i + 1));

			System.out.print("Enter ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter Name: ");
			String name = scanner.nextLine();

			System.out.print("Enter Department: ");
			String dept = scanner.nextLine();

			System.out.println("Select Type: 1. Undergraduate  2. Postgraduate");
			int choice = scanner.nextInt();

			Student s = null;

			switch (choice) {
			case 1:
				s = new UndergraduateStudent(id, name, dept);
				break;

			case 2:
				s = new PostgraduateStudent(id, name, dept);
				break;

			default:
				System.out.println("Invalid choice! Skipping student...");
				continue;
			}

			// Add marks
			System.out.print("Enter number of subjects: ");
			int n = scanner.nextInt();
			scanner.nextLine();

			for (int j = 0; j < n; j++) {
				System.out.print("Enter subject: ");
				String subject = scanner.nextLine();

				System.out.print("Enter marks: ");
				int marks = scanner.nextInt();
				scanner.nextLine();

				s.addMark(subject, marks);
			}

			student.addStudent(s);
		}

		boolean sortAgain = true;

		while (sortAgain) {
			System.out.println("\nSelect an option:");
			System.out.println("1. Ranked");
			System.out.println("2. Sort by Name");
			System.out.println("3. Sort by Department");
			System.out.println("4. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine(); // consume leftover newline

			switch (choice) {
			case 1:
				System.out.println("=======Ranked========");
				for (Student s : student.getRankedStudents()) {
					System.out.println(s);
				}
				break;

			case 2:
				System.out.println("=======SortByName========");
				for (Student s : student.sortByName()) {
					System.out.println(s);
				}
				break;

			case 3:
				System.out.println("=======SortByDepartment========");
				for (Student s : student.sortStudentsByDepartment()) {
					System.out.println(s);
				}
				break;

			case 4:
				sortAgain = false;
				System.out.println("Exiting sorting menu.");
				continue; // skip the "sort again" prompt

			default:
				System.out.println("Invalid option. Please select 1, 2, 3, or 4.");
			}

			// Ask user if they want to sort again
			if (sortAgain) {
				System.out.print("\nDo you want to sort again? (yes/no): ");
				String response = scanner.nextLine().trim().toLowerCase();
				if (!response.equals("yes")) {
					sortAgain = false;
					System.out.println("Exiting sorting menu.");
				}
			}
		}

		scanner.close();

	}

}
