package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.model.Course;
import com.studentcourse.util.DBConnection;

public class CourseDAO {

	public boolean addCourse(Course course) {
		String sql = "INSERT INTO courses (course_name, duration, fees, trainer_name) VALUES (?, ?, ?, ?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, course.getCourseName());
			ps.setString(2, course.getDuration());
			ps.setDouble(3, course.getFees());
			ps.setString(4, course.getTrainerName());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

		public List<Course> getAllCourses() {

		    List<Course> list = new ArrayList();

		    String sql = "SELECT * FROM courses";

		    try (
		        Connection con = DBConnection.getConnection();
		        PreparedStatement ps = con.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery()
		    ) {

		        while (rs.next()) {

		            Course c = new Course();
		            c.setId(rs.getInt("id"));
		            c.setCourseName(rs.getString("course_name"));
		            c.setDuration(rs.getString("duration"));
		            c.setFees(rs.getDouble("fees"));
		            c.setTrainerName(rs.getString("trainer_name"));

		            list.add(c);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}

		public Course getCourseById(int courseId) {
			 Course course = null;

			    String sql = "SELECT * FROM courses WHERE id=?";

			    try (
			        Connection con = DBConnection.getConnection();
			        PreparedStatement ps = con.prepareStatement(sql)
			    ) {

			        ps.setInt(1, courseId);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {

			            course = new Course();
			            course.setId(rs.getInt("id"));
			            course.setCourseName(rs.getString("course_name"));
			            course.setDuration(rs.getString("duration"));
			            course.setFees(rs.getDouble("fees"));
			            course.setTrainerName(rs.getString("trainer_name"));
			        }

			    } catch (Exception e) {
			        e.printStackTrace();
			    }

			    return course;
			}

		public boolean updateCourse(Course course) {

		    String sql = "UPDATE courses SET course_name=?, duration=?, fees=?, trainer_name=? WHERE id=?";

		    try (
		        Connection con = DBConnection.getConnection();
		        PreparedStatement ps = con.prepareStatement(sql)
		    ) {

		        ps.setString(1, course.getCourseName());
		        ps.setString(2, course.getDuration());
		        ps.setDouble(3, course.getFees());
		        ps.setString(4, course.getTrainerName());
		        ps.setInt(5, course.getId());

		        return ps.executeUpdate() > 0;

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return false;
		}

		public boolean deleteCourse(int id) {

		    String sql = "DELETE FROM courses WHERE id=?";

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

