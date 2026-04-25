package com.monocept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.monocept.exception.StudentNotFoundException;
import com.monocept.model.Student;
import com.monocept.util.DBUtil;

public class StudentDAO {

	public int addStudent(Student s) throws SQLException {

		String sql = "INSERT INTO student(student_name, age, branch_id) VALUES (?, ?, ?)";

		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setInt(3, s.getBranchId());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				return rs.getInt(1);
			}

			return -1;
		}
	}

	public boolean exists(Connection con, int studentId) throws SQLException {

		String sql = "SELECT 1 FROM student WHERE student_id =?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, studentId);

			ResultSet rs = ps.executeQuery();
			return rs.next();
		}
	}

	public void updateStudent(int studentId, String name, int age) {

		String sql = "UPDATE Student set student_name=?, age=? where student_id=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setInt(3, studentId);

			if (ps.executeUpdate() > 0)

				System.out.println("Updated");
			else
				throw new StudentNotFoundException("Student not found");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void deleteStudent(Connection con, int studentId) throws SQLException {
		try (PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE student_id=?")) {
			ps.setInt(1, studentId);
			ps.executeUpdate();

		}
	}

	public void getStudentById(int studentId) throws Exception {

		String sql = "SELECT s.student_id, s.student_name, s.age, s.branch_id, " +
	             "r.course_id, r.fees_paid " +
	             "FROM Student s " +
	             "LEFT JOIN Registration r ON s.student_id = r.student_id " +
	             "WHERE s.student_id = ?";
		Connection conn = DBUtil.getConnection();

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, studentId);
		ResultSet rs = ps.executeQuery();

		boolean found = false;

		System.out.println("\n===== Student Details =====");

		while (rs.next()) {

			found = true;

			int id = rs.getInt("student_id");
			String name = rs.getString("student_name");
			int age = rs.getInt("age");
			int branchId = rs.getInt("branch_id");
			int courseId = rs.getInt("course_id");
			double fee = rs.getDouble("fees_paid");

//			Student s = new Student();
//			s.setStudentId(rs.getInt("student_id"));
//			s.setName(rs.getString("student_name"));
//			s.setAge(rs.getInt("age"));
//			s.setBranchId(rs.getInt("branch_id"));
//			
//			return s;

			System.out.print(studentId + " | " + name + " | " + age + " | " + branchId + " | ");

			if (rs.wasNull()) {
				System.out.println("No Course");
			} else {
				System.out.println("Course: " + courseId + " | Fee: " + fee);
			}
		}

		if (!found) {
			System.out.println("Student not found.");
		}
		

	}

	public void getAllStudentsWithCourses() throws SQLException {

		String sql = "SELECT s.student_id, s.student_name, s.age, s.branch_id, r.course_id, r.fees_paid "
				+ "FROM student s " + "LEFT JOIN Registration r ON s.student_id = r.student_id "
				+ "ORDER BY s.student_id";

		try (Connection con = DBUtil.getConnection();

				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {

			boolean hasData = false;

			System.out.println("\n===== Students with Courses =====");
			System.out.println("ID | Name | Age | BranchId | CourseId | Fee");
			System.out.println("--------------------------------------------------");
			while (rs.next()) {
				hasData = true;

				int id = rs.getInt("student_id");
				String name = rs.getString("student_name");
				int age = rs.getInt("age");
				int branchId = rs.getInt("branch_id");
				String courseName = rs.getString("course_id");
				double feesPaid = rs.getDouble("fees_paid");

				if (courseName == null) {
					courseName = "No Course";
					System.out.println(id + " | " + name + " | " + age + " | " + branchId + " | " + courseName);
				} else {
					System.out.println(id + " | " + name + " | " + age + " | " + branchId + " | " + courseName
							+ " | Fee: " + feesPaid);
				}
			}
			if (!hasData) {
				System.out.println("No records found.");
			}
		} catch (Exception e) {
			System.out.println("Error fetching data ");
			e.printStackTrace();
		}
	}

}
