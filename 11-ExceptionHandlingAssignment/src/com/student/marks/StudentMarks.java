package com.student.marks;

public class StudentMarks {

	public void gradingProcess(String name, int marks) throws InvalidMarksException {
		
		if(name == null) {
			
			throw new NullPointerException("Student name cannot be null");
		}
		if (marks < 0 || marks > 100) {

			throw new InvalidMarksException("Please enter marks between 1-100");

		}
	
		if (marks >= 75)
			System.out.println("A");
		else if (marks >= 60)
			System.out.println("B");
		else if (marks >= 50)
			System.out.println("C");
		else
			System.out.println("FAIL");
		
	}
}
