package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.Course;
import com.monocept.model.OnlineCourses;
import com.monocept.model.RegularCourses;

public class CourseManagementSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of courses");
		int n = scanner.nextInt();
		
		scanner.nextLine();

		if (n <= 0) {
			System.out.println("Number of course greater than 0");
			scanner.close();
			return;
		}
		Course[] courses = new Course[n];

		int i = 0;
		while (i < n) {

			System.out.println("\nEnter details of course: " + (i + 1));

			System.out.print("Enter Course ID: ");
			int id = scanner.nextInt();

			scanner.nextLine();

			if (id <= 0) {
				System.out.println("Course Id must be positive");
				continue;
			}

			System.out.print("Enter Course Name: ");
			String name = scanner.nextLine();

			if (name.trim().isEmpty()) {
				System.out.println("course Name cannot be empty");
				continue;
			}
			System.out.print("Enter Base Fee: ");
			double baseFee = scanner.nextDouble();

			if (baseFee <= 0) {
				System.out.println("Base fee muts  be positive:");
				continue;
			}
			System.out.println("Enter course type (1-regular,2-online) ");
			int type = scanner.nextInt();

			if (type != 1 && type != 2) {

				System.out.println("Invalid type. Enter 1 or 2");
				continue;
			}

			if (type == 1) {
				System.out.println("Enter lab fee:");
				double labFee = scanner.nextDouble();
				if (labFee < 0) {

					System.out.println("Lab fee cannot be negative");
					continue;
				}
				courses[i] = new RegularCourses(id, name, baseFee, labFee);
			} else {
				

				System.out.print("Enter Platform Fee: ");
				double platformFee = scanner.nextDouble();

				if (platformFee < 0) {
					System.out.println("Platform fee cannot be negative");
					continue;
			}
				courses[i] = new OnlineCourses(id, name, baseFee, platformFee);
			}
            i++;
		}
	
			System.out.println("====Course Details===");
			for (Course c : courses) {

				System.out.println("CourseName: " + c.courseName);
				System.out.println("Final fee: " + c.calculateFee());

			}
			System.out.println("Total Course Created " + Course.getTotalCourses());
			scanner.close();

		}
	}


