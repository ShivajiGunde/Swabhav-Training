package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentcourse.model.Admin;
import com.studentcourse.util.DBConnection;

public class AdminDAO {

	public static boolean isValid(String username, String password){

//		// Validating the username and password
//		if (username == null || username.trim().isEmpty()) {
//			System.out.println("Username is required");
//			return false;
//		}
//		if (password == null || password.trim().isEmpty()) {
//			System.out.println("Password is required");
//			return false;
//		}

		String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

		boolean status = false;

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, username);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {
					status = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static int login(String username, String password) {

		String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, username);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next())

					return 1;
				else
					return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

}
