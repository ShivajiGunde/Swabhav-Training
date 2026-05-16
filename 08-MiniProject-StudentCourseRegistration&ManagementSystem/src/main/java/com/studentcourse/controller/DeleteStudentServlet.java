package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {

	StudentDAO studentDAO;

	@Override
	public void init() {
		studentDAO = new StudentDAO();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int studentId = Integer.parseInt(request.getParameter("studentId"));

		// Check whether student is registered in any course
		boolean isRegistered = studentDAO.isStudentRegistered(studentId);

		if (isRegistered) {

			// Student already registered in a course
			request.setAttribute("errorMessage", "Cannot delete student. Student is registered in a course.");

			request.getRequestDispatcher("WEB-INF/views/student-list.jsp").forward(request, response);

		} else {

			// Delete student
			boolean deleted = studentDAO.deleteStudent(studentId);

			if (deleted) {
				response.sendRedirect("ViewStudentServlet");
			} else {
				request.setAttribute("errorMessage", "Failed to delete student.");

				request.getRequestDispatcher("WEB-INF/views/student-list.jsp").forward(request, response);
			}
		}
	}

}
