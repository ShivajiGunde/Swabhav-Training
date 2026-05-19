package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		resp.setContentType("text/html");

		String studentName = req.getParameter("studentName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String ageStr = req.getParameter("age");
		String city = req.getParameter("city");

		String errorMessage = null;

		if (studentName == null || studentName.trim().isEmpty()) {

			errorMessage = "Student Name is required";

		} else if (!studentName.matches("[A-Za-z ]{3,50}")) {

			errorMessage = "Student Name must contain only letters and spaces";
		} else if (email == null || email.trim().isEmpty()) {

			errorMessage = "Email is required";

		} else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

			errorMessage = "Invalid Email Format";
		} else if (phone == null || phone.trim().isEmpty()) {

			errorMessage = "Phone is required";

		} else if (!phone.matches("[0-9]{10}")) {

			errorMessage = "Phone Number must contain exactly 10 digits";
		} else if (ageStr == null || ageStr.trim().isEmpty()) {

			errorMessage = "Age is required";

		} else if (city == null || city.trim().isEmpty()) {

			errorMessage = "City is required";
		} else if (!city.matches("[A-Za-z ]{3,50}")) {

			errorMessage = "City must contain only letters and spaces";
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

		if (errorMessage != null) {

		    Student student = new Student();

		    student.setStudentName(studentName);
		    student.setEmail(email);
		    student.setPhone(phone);
		    student.setCity(city);

		    // age only if valid
		    try {
		        student.setAge(Integer.parseInt(ageStr));
		    } catch (Exception e) {
		    }

		    req.setAttribute("student", student);

		    req.setAttribute("errorMessage", errorMessage);

		    req.getRequestDispatcher("/WEB-INF/views/student-form.jsp")
		       .forward(req, resp);

		    return;
		}

		Student student = new Student();

		student.setStudentName(studentName);
		student.setEmail(email);
		student.setPhone(phone);
		student.setAge(age);
		student.setCity(city);

		StudentDAO dao = new StudentDAO();

		boolean status = false;

		try {

			status = dao.addStudent(student);

		} catch (Exception e) {

			e.printStackTrace();

			errorMessage = "Database Error";
		}

		if (status) {

			resp.sendRedirect("ViewStudentsServlet");

		} else {
			req.setAttribute("errorMessage", "Failed to Add Student");

			req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req, resp);
		}
	}
}