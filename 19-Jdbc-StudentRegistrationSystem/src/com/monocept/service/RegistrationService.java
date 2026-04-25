package com.monocept.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.monocept.dao.RegistrationDAO;
import com.monocept.dao.StudentDAO;
import com.monocept.model.Registration;
import com.monocept.util.DBUtil;

public class RegistrationService {

	StudentDAO studentDao = new StudentDAO();
	RegistrationDAO registrationDao = new RegistrationDAO();

	public void registerCourse(Registration r) {

		if (r.getFeesPaid() <= 0) {
			System.out.println("Invalid fee");
			return;
		}

		try (Connection con = DBUtil.getConnection()) {

			con.setAutoCommit(false); // Transaction

			if (r.getFeesPaid() <= 0)
				throw new RuntimeException("Fee must be positive");

			if (!studentDao.exists(con, r.getStudentId()))
				throw new RuntimeException("Student not found");

			if (registrationDao.isDuplicate(con, r))
				throw new RuntimeException("Duplicate registration");

			registrationDao.registerCourse(con, r);

			con.commit();
			System.out.println("Registered successfully");

		} catch (Exception e) {
			System.out.println("Transaction failed: " + e.getMessage());
		}
	}

	public void updateCourseFees(int studentId, int courseId, double newFees) throws SQLException {

		if (newFees <= 0) {
			System.out.println("Invalid fee");
			return;
		}

		registrationDao.updateCourseFees( studentId, courseId, newFees);

	}

	public void deleteByStudent(Connection con, int studentId) throws SQLException {

		registrationDao.deleteByStudent(con, studentId);

	}

	public void cancelRegistration(int studentId, int courseId) throws SQLException {

		registrationDao.deleteCourse(studentId, courseId);

		System.out.println("Registration cancelled");
	}

	public void highPaying(double amount) {

		registrationDao.highPaying(amount);

		System.out.println("Report fetched successfully");
	}

	public void courseCount() {
		
		registrationDao.courseCount();
		
	}
}
