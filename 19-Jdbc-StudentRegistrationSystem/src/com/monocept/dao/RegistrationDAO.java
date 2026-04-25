package com.monocept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.monocept.model.Registration;
import com.monocept.util.DBUtil;

public class RegistrationDAO {

	public boolean registerCourse(Connection con, Registration r) throws SQLException {
		String sql = "INSERT INTO registration(student_id, course_id, fees_paid) VALUES (?, ?, ?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, r.getStudentId());
			ps.setInt(2, r.getCourseId());
			ps.setDouble(3, r.getFeesPaid());
			return ps.executeUpdate() > 0;
		}
	}

	public boolean isDuplicate(Connection con, Registration r) throws SQLException {

		String sql = "SELECT 1 FROM registration WHERE student_id=? AND course_id=?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, r.getStudentId());
			ps.setInt(2, r.getCourseId());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		}

	}
	
	
	
	//==========Update fees paid==============
	public void updateCourseFees(int studentId, int courseId, double newFees) throws SQLException {
		
		if(newFees <= 0) {
			System.out.println("Fees must be positive");
			return;
		}
		
		String checkRegistration = "SELECT * FROM Registration WHERE student_id=? and course_id=?";
		String updateFees = "UPDATE Registration SET fees_paid=? WHERE student_id=? and course_id=? ";
		
		try(Connection con = DBUtil.getConnection();
				PreparedStatement checkStmt = con.prepareStatement(checkRegistration);
				PreparedStatement updateStmt = con.prepareStatement(updateFees)){
					
			checkStmt.setInt(1, studentId);
			checkStmt.setInt(2, courseId);
			
	        ResultSet rs = checkStmt.executeQuery();
	        
	        if (!rs.next()) {
	            System.out.println("Registration not found.");
	            return;
	        }
	        
	        updateStmt.setDouble(1, newFees);
	        updateStmt.setInt(2, studentId);
	        updateStmt.setInt(3, courseId);

	        int rows = updateStmt.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Fees updated successfully.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

				}
	

//	public void updateCourseFees(int studentId, int courseId, double feesPaid) {
//
//		String sql = "Update Course set fees_paid=? WHERE student_id=? AND course_name=?";
//
//		try (Connection con = DBUtil.getConnection()) {
//
//			PreparedStatement ps = con.prepareStatement(sql);
//
//			ps.setDouble(1, feesPaid);
//			ps.setInt(2, studentId);
//			ps.setString(3, courseName);
//
//			System.out.println(ps.executeUpdate() > 0 ? "Fee Updated" : "Record not found");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	public void deleteByStudent(Connection con, int studentId) throws SQLException {
		String sql = "DELETE FROM Registration WHERE student_id=?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, studentId);
			ps.executeUpdate();
		}
	}

	public void deleteCourse(int studentId, int courseId) throws SQLException {

		String sql = "Delete From Registration where student_id=? and course_id=?";

		try (Connection con = DBUtil.getConnection();

				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, studentId);
			ps.setInt(2, courseId);
			ps.executeUpdate();

		} catch (Exception e) {

			System.out.println("error " + e.getMessage());
		}

	}

	// 9. High Paying

	public void highPaying(double amount) {

		String sql = "SELECT s.student_name, r.course_id, r.fees_paid "
				+ "FROM student s JOIN registration r ON s.student_id=r.student_id " + "WHERE r.fees_paid > ?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setDouble(1, amount);
			ResultSet rs = ps.executeQuery();

			boolean found = false;

			while (rs.next()) {
				found = true;
				System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getDouble(3));
			}

			if (!found)
				System.out.println("No results!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 10. Course-wise Count
	public void courseCount() {

		 String sql = "SELECT c.course_name, COUNT(*) " +
                 "FROM Registration r " +
                 "JOIN Course c ON r.course_id = c.course_id " +
                 "GROUP BY c.course_id, c.course_name";

		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			boolean found = false;

			while (rs.next()) {
				found = true;
				System.out.println(rs.getString(1) + " → " + rs.getInt(2));
			}

			if (!found)
				System.out.println("No data!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	

	
}
