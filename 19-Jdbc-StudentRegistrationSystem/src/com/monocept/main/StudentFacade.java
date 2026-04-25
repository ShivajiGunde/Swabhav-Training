package com.monocept.main;

import java.sql.SQLException;

import com.monocept.exception.StudentNotFoundException;
import com.monocept.model.Registration;
import com.monocept.model.Student;
import com.monocept.service.RegistrationService;
import com.monocept.service.StudentService;

public class StudentFacade {

	private StudentService studentService = new StudentService();
	private RegistrationService registrationService = new RegistrationService();

	public void addStudent(Student s) {
		studentService.addStudent(s);
	}

	public void registerCourse(Registration r) {
		registrationService.registerCourse(r);
	}

	public void viewAllStudentsWithCourses() {
		try {
			studentService.getAllStudentsWithCourses();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void searchStudentById(int studentId) throws StudentNotFoundException {
		
		Student s = new Student();
		
		 studentService.getStudentById(studentId);
		
		if( s == null) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found");

		}
	}

	public void updateStudent(int studentId, String name, int age) {
		studentService.updateStudent(studentId,name,age);
	}

	public void updateCourseFee(int studentId, int courseId, double newFees) throws SQLException {
		registrationService.updateCourseFees(studentId, courseId, newFees);
	}

	public void cancelRegistration(int studentId, int courseId) {
		try {
			registrationService.cancelRegistration(studentId, courseId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteStudent(int id) {
		studentService.deleteStudent(id);
	}

	public void highPayingStudentsReport(double amount) {
		
		registrationService.highPaying(amount);
		
	}

	public void courseWiseStudentCount() {
		
		registrationService.courseCount();
	}

	
}