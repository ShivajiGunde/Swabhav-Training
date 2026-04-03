package com.student.marks;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InvalidMarksException {

		Scanner scanner = new Scanner(System.in);

		StudentMarks s = new StudentMarks();

		try {

			System.out.println("Enter the name");
			String name = scanner.nextLine();

			System.out.println("Enter the marks");
			int marks = scanner.nextInt();

			s.gradingProcess(name, marks);

		} catch (NullPointerException e) {

			System.out.println("name required");
		} catch (InvalidMarksException e) {

			System.out.println(e.getMessage());
		} finally {

			System.out.println("Grading process completed ");
			scanner.close();
		}
	}

}
