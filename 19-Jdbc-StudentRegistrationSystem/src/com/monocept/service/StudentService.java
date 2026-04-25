package com.monocept.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.monocept.dao.RegistrationDAO;
import com.monocept.dao.StudentDAO;
import com.monocept.exception.StudentNotFoundException;
import com.monocept.model.Student;
import com.monocept.util.DBUtil;

public class StudentService {

	StudentDAO studentDao = new StudentDAO();
	RegistrationDAO rDao = new RegistrationDAO();

	public void addStudent(Student s) {
		if (s.getName().isEmpty() || s.getAge() <= 0) {
			System.out.println("Invalid input");
			return;
		}

		try {
			studentDao.addStudent(s);
			System.out.println("Student added");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void updateStudent(int studentId, String name, int age) {
		try {
			studentDao.updateStudent(studentId, name, age);
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}

	}

	public void deleteStudent(int studentId) {

		Connection con = null;
		try {

			con = DBUtil.getConnection();

			con.setAutoCommit(false);

			rDao.deleteByStudent(con, studentId);

			studentDao.deleteStudent(con, studentId);

			con.commit();

		} catch (Exception e) {
			if (con != null) {
				try {
					con.rollback();

				} catch (SQLException ignored) {
				}
			}
			throw new RuntimeException(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignored) {
				}
			}
		}
	}

	// =====Get Student By Id========
	public void getStudentById(int studentId) {
		try {
			studentDao.getStudentById(studentId);

		} catch (Exception e) {

			System.out.println("Error " + e.getMessage());
		}
	}

	public void getAllStudentsWithCourses() throws SQLException {
		try {
			studentDao.getAllStudentsWithCourses();

		} catch (Exception e) {

			System.out.println("Error " + e.getMessage());
		}
	}
}
