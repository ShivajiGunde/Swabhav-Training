package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String studentIdStr = req.getParameter("studentId");
		String studentName = req.getParameter("studentName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String ageStr = req.getParameter("age");
		String city = req.getParameter("city");

		String errorMessage = null;

		// VALIDATION
		if (studentName == null || studentName.trim().isEmpty()) {

			errorMessage = "Student Name is required";

		} else if (email == null || email.trim().isEmpty()) {

			errorMessage = "Email is required";

		} else if (phone == null || phone.trim().isEmpty()) {

			errorMessage = "Phone is required";

		} else if (ageStr == null || ageStr.trim().isEmpty()) {

			errorMessage = "Age is required";

		} else if (city == null || city.trim().isEmpty()) {

			errorMessage = "City is required";
		}

		int studentId = 0;

		if (studentIdStr == null || studentIdStr.trim().isEmpty()) {
		    errorMessage = "ID is missing";
		} else {
		    try {
		        studentId = Integer.parseInt(studentIdStr);
		    } catch (NumberFormatException e) {
		        errorMessage = "Invalid Student ID";
		    }
		}
		
		int age = 0;
		if (errorMessage == null) {

			try {

				age = Integer.parseInt(ageStr);

				if (age < 18) {

					errorMessage = "Age must be 18 or above";
				}

			} catch (NumberFormatException e) {

				errorMessage = "Age must be a valid number";
			}
		}

		Student student = new Student();

		student.setStudentId(studentId);
		student.setStudentName(studentName);
		student.setEmail(email);
		student.setPhone(phone);
		student.setAge(age);
		student.setCity(city);

		// IF ERROR
		if (errorMessage != null) {

			req.setAttribute("errorMessage", errorMessage);

			req.setAttribute("student", student);

			req.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(req, resp);

			return;
		}

		StudentDAO dao = new StudentDAO();
		
		

		boolean status = false;

		try {

			status = dao.updateStudent(student);

		} catch (Exception e) {

			e.printStackTrace();
		}

		if (status) {

			resp.sendRedirect("ViewStudentsServlet");

		} else {

			req.setAttribute("errorMessage", "Failed to Update Student");

			req.setAttribute("student", student);

			req.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(req, resp);
		}
	}
}