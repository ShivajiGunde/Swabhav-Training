package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.model.Student;
import com.studentcourse.util.DBConnection;

public class StudentDAO {

	public static boolean addStudent(Student student) throws Exception {

		boolean status = false;

		String sql = "INSERT INTO students(student_name,email,phone,age,city) " + "VALUES(?,?,?,?,?)";

		try (Connection con = DBConnection.getConnection();

				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getPhone());
			ps.setInt(4, student.getAge());
			ps.setString(5, student.getCity());

			int rows = ps.executeUpdate();

			if (rows > 0) {

				status = true;
			}
		}

		return status;
	}

	public static List<Student> getAllStudents() throws Exception {

		List<Student> studentList = new ArrayList<>();

		String sql = "SELECT * FROM students";

		try (Connection con = DBConnection.getConnection();

				PreparedStatement ps = con.prepareStatement(sql)){

				ResultSet rs = ps.executeQuery(); {

			while (rs.next()) {

				Student student = new Student();

				student.setStudentId(rs.getInt("student_id"));

				student.setStudentName(rs.getString("student_name"));

				student.setEmail(rs.getString("email"));

				student.setPhone(rs.getString("phone"));

				student.setAge(rs.getInt("age"));

				student.setCity(rs.getString("city"));

				studentList.add(student);
			}
			
		}
				return studentList;}

	}

	public Student getStudentById(int studentId) {

		Student student = null;

		String sql = "SELECT * FROM students WHERE student_id=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, studentId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				student = new Student();

	            student.setStudentId(rs.getInt("student_id")); // IMPORTANT
				student.setStudentName(rs.getString("student_name"));
				student.setEmail(rs.getString("email"));
				student.setPhone(rs.getString("phone"));
				student.setAge(rs.getInt("age"));
				student.setCity(rs.getString("city"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return student;
	}

	public boolean updateStudent(Student student) throws Exception {

	    boolean status = false;

	    String sql =
	        "UPDATE students SET " +
	        "student_name=?, " +
	        "email=?, " +
	        "phone=?, " +
	        "age=?, " +
	        "city=? " +
	        "WHERE student_id=?";

	    try (Connection con = DBConnection.getConnection();

	         PreparedStatement ps =
	                 con.prepareStatement(sql)) {

	    	System.out.println(student);
	    	
	        ps.setString(1, student.getStudentName());

	        ps.setString(2, student.getEmail());

	        ps.setString(3, student.getPhone());

	        ps.setInt(4, student.getAge());

	        ps.setString(5, student.getCity());

	        ps.setInt(6, student.getStudentId());

	        int rows = ps.executeUpdate();

	        System.out.println("Rows Updated = " + rows);

	        if (rows > 0) {

	            status = true;
	        }
	    }

	    return status;
	}

	
	
	public boolean isStudentRegistered(int studentId) {
		String sql = "SELECT 1 FROM registrations WHERE student_id = ?";
		
		

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, studentId);

			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	

	public boolean deleteStudent(int studentId) {
		String sql = "DELETE FROM students WHERE student_id = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, studentId);

			int rowsAffected = ps.executeUpdate();

			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}

