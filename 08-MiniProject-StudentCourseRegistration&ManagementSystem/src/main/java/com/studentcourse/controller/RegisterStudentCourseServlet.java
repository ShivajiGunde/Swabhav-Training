package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.model.Registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterStudentCourseServlet")
public class RegisterStudentCourseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String studentIdStr = req.getParameter("studentId");
		String courseIdStr = req.getParameter("courseId");

		if (studentIdStr == null || courseIdStr == null || studentIdStr.trim().isEmpty()
				|| courseIdStr.trim().isEmpty()) {

			req.setAttribute("errorMessage", "Student ID and Course ID are required");
			req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(req, resp);
			return;
		}

		int studentId;
		int courseId;

		try {
			studentId = Integer.parseInt(studentIdStr);
			courseId = Integer.parseInt(courseIdStr);
		} catch (NumberFormatException e) {

			req.setAttribute("errorMessage", "Invalid ID format");
			req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(req, resp);
			return;
		}

		RegistrationDAO dao = new RegistrationDAO();

		// ✅ CHECK DUPLICATE
		if (dao.isAlreadyRegistered(studentId, courseId)) {

			req.setAttribute("errorMessage", "Student is already registered for this course");

			req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(req, resp);
			return;
		}

		// SAVE REGISTRATION
		Registration r = new Registration();
		r.setStudentId(studentId);
		r.setCourseId(courseId);
		r.setRegistrationDate(new java.sql.Date(System.currentTimeMillis()));
		r.setStatus("ACTIVE");

		boolean success = dao.registerStudentCourse(r);

		if (success) {
			resp.sendRedirect("ViewRegistrationsServlet");
		} else {
			req.setAttribute("errorMessage", "Registration failed");
			req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		    req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp")
		        .forward(req, resp);
		}	
}