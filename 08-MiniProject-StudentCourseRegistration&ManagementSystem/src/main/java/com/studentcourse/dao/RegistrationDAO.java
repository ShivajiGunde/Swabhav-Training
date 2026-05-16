package com.studentcourse.dao;
import java.sql.*;
import java.util.*;


	import com.studentcourse.model.Registration;
import com.studentcourse.util.DBConnection;

	public class RegistrationDAO {

	    public boolean registerStudentCourse(Registration r) {

	        String sql = "INSERT INTO registrations(student_id, course_id, registration_date, status) VALUES (?, ?, ?, ?)";

	        try (
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(sql)
	        ) {

	            ps.setInt(1, r.getStudentId());
	            ps.setInt(2, r.getCourseId());
	            ps.setDate(3, r.getRegistrationDate());
	            ps.setString(4, r.getStatus());

	            return ps.executeUpdate() > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return false;
	    }

	    public List<Registration> getAllRegistrations() {

	        List<Registration> list = new ArrayList<>();

	        String sql = "SELECT * FROM registrations";

	        try (
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery()
	        ) {

	            while (rs.next()) {

	                Registration r = new Registration();

	                r.setRegistrationId(rs.getInt("registration_id"));
	                r.setStudentId(rs.getInt("student_id"));
	                r.setCourseId(rs.getInt("course_id"));
	                r.setRegistrationDate(rs.getDate("registration_date"));
	                r.setStatus(rs.getString("status"));

	                list.add(r);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	    public boolean updateStatus(int id, String status) {

	        String sql = "UPDATE registrations SET status=? WHERE registration_id=?";

	        try (
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(sql)
	        ) {

	            ps.setString(1, status);
	            ps.setInt(2, id);

	            return ps.executeUpdate() > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return false;
	    }

	    public boolean deleteRegistration(int id) {

	        String sql = "DELETE FROM registrations WHERE registration_id=?";

	        try (
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(sql)
	        ) {

	            ps.setInt(1, id);

	            return ps.executeUpdate() > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return false;
	    }
	}


