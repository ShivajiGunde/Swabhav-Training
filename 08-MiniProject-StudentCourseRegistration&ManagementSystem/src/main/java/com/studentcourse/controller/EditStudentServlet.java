package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String studentIdStr = req.getParameter("studentId");

		if (studentIdStr == null || studentIdStr.isEmpty()) {

			resp.getWriter().println("Student ID is missing");
			return;
		}

		int studentId = Integer.parseInt(studentIdStr);

		StudentDAO dao = new StudentDAO();

		Student student = dao.getStudentById(studentId);

		if (student == null) {

			resp.getWriter().println("Student not found");
			return;
		}

		req.setAttribute("student", student);

		req.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(req, resp);

	}
}