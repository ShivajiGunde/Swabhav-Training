package com.studentcourse.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.studentcourse.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		Connection con = null;

		int totalStudents = 0;
		int totalCourses = 0;
		int totalRegistrations = 0;

		try {
			con = DBConnection.getConnection();

			PreparedStatement ps1 = con.prepareStatement("SELECT COUNT(*) FROM students");
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()) {
				totalStudents = rs1.getInt(1);
			}

			PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM courses");
			ResultSet rs2 = ps2.executeQuery();
			if (rs2.next()) {
				totalCourses = rs2.getInt(1);
			}

			PreparedStatement ps3 = con.prepareStatement("SELECT COUNT(*) FROM registrations");
			ResultSet rs3 = ps3.executeQuery();
			if (rs3.next()) {
				totalRegistrations = rs3.getInt(1);
			}

			request.setAttribute("totalStudents", totalStudents);
			request.setAttribute("totalCourses", totalCourses);
			request.setAttribute("totalRegistrations", totalRegistrations);

			request.getRequestDispatcher("WEB-INF/views/dashboard.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
		}
	}
}
