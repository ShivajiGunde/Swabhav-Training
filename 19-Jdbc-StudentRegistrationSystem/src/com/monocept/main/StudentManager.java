package com.monocept.main;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.monocept.exception.StudentNotFoundException;
import com.monocept.model.Registration;
import com.monocept.model.Student;

public class StudentManager {

	private StudentFacade facade = new StudentFacade();
	private Scanner sc = new Scanner(System.in);

	public void start() throws SQLException, StudentNotFoundException {

		while (true) {

			System.out.println("\n===== MENU =====");
			System.out.println("1. Add Student");
			System.out.println("2. Register for Course");
			System.out.println("3. View All Students with Courses");
			System.out.println("4. Search Student by ID");
			System.out.println("5. Update Student");
			System.out.println("6. Update Course Fee");
			System.out.println("7. Cancel Registration");
			System.out.println("8. Delete Student");
			System.out.println("9. High Paying Students Report");
			System.out.println("10. Course-wise Student Count");
			System.out.println("11. Exit");

			System.out.print("Enter choice: ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				addStudent();
				break;

			case 2:
				registerCourse();
				break;

			case 3:
				facade.viewAllStudentsWithCourses();
				break;

			case 4:
				System.out.print("Enter ID: ");
				facade.searchStudentById(sc.nextInt());
				break;

			case 5:
				updateStudent();
				break;

			case 6:
				updateFee();
				break;

			case 7:
				cancelRegistration();
				break;

			case 8:
				System.out.print("Enter ID: ");
				facade.deleteStudent(sc.nextInt());
				break;

			case 9:
				System.out.print("Enter minimum amount: ");
				double amount = sc.nextDouble();
				facade.highPayingStudentsReport(amount);
				break;

			case 10:
				facade.courseWiseStudentCount();
				break;

			case 11:
				System.out.println("Exiting...");
				System.exit(0);

			default:
				System.out.println("Invalid choice");
			}
		}
	}

	private void addStudent() {

		String name;
		while (true) {
			try {
				System.out.print("Enter name: ");
				name = sc.next();

				if (name == null || !name.trim().matches("^[A-Za-z ]{2,50}$")) {
					throw new IllegalArgumentException("Name must contain only alphabets and cannot be empty!");
				}
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid name. Try again");
			}

		}
		int age;
		while (true) {
			try {
				System.out.print("Enter age: ");
				age = sc.nextInt();

				if (age <= 0) {
					throw new IllegalArgumentException("Age must be greater than 0");
				}
				break;
			} catch (InputMismatchException e) {

				System.out.println("Invalid input! enter valid number ");
				sc.nextLine();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.print("Enter branchId: ");
		int branchId = sc.nextInt();

		Student s = new Student(name, age, branchId);
		facade.addStudent(s);

	}

	private void registerCourse() {
		System.out.print("Student ID: ");
		int studentId = sc.nextInt();
		System.out.print("Course Id: ");
		int courseId = sc.nextInt();

		double fees;
		while (true) {
			try {
				System.out.print("Fee: ");
				fees = sc.nextDouble();

				if (fees <= 0) {
					throw new IllegalArgumentException("fees must be grater than 0");
				}
				break;

			} catch (InputMismatchException e) {

				System.out.println("Invalid input! enter valid number ");
				sc.nextLine();

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		Registration r = new Registration(studentId, courseId, fees);
		facade.registerCourse(r);
	}

	private void updateStudent() {
		System.out.print("ID: ");
		int studentId = sc.nextInt();

		String name;
		while (true) {
			try {
				System.out.print("Name: ");
				name = sc.nextLine();

				if (name == null || !name.trim().matches("^[A-Za-z ]{2,50}$")) {
					throw new IllegalArgumentException("Name must contain only alphabets and cannot be empty!");
				}
				break;
			} catch (IllegalArgumentException e) {

				System.out.println("Invalid name.Try again");
			}
		}

		int age;
		while (true) {
			try {
				System.out.print("Age: ");
				age = sc.nextInt();

				if (age <= 0) {
					throw new IllegalArgumentException("Age must be greater than 0");
				}
				break;
			} catch (InputMismatchException e) {

				System.out.println("Invalid input! enter valid number ");
				sc.nextLine();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		facade.updateStudent(studentId, name, age);
	}

	private void updateFee() throws SQLException {
		System.out.print("Student ID: ");
		int id = sc.nextInt();
		System.out.print("Course id: ");
		int courseId = sc.nextInt();

		double newfees;
		while (true) {
			try {
				System.out.print("Fee: ");
				newfees = sc.nextDouble();

				if (newfees <= 0) {
					throw new IllegalArgumentException("fees must be grater than 0");
				}
				break;
			} catch (InputMismatchException e) {

				System.out.println("Invalid input! enter valid number ");
				sc.nextLine();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

		}

		facade.updateCourseFee(id, courseId, newfees);
	}

	private void cancelRegistration() {
		System.out.print("Student ID: ");
		int id = sc.nextInt();
		System.out.print("Course Id: ");
		int courseId = sc.nextInt();

		facade.cancelRegistration(id, courseId);
	}
}