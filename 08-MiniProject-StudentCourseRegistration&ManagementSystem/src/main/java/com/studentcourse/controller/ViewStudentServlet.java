package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewStudentsServlet")
public class ViewStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			List<Student> studentList = StudentDAO.getAllStudents();

			req.setAttribute("studentList", studentList);

			req.getRequestDispatcher("WEB-INF/views/viewStudents.jsp").forward(req, resp);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("errorMessage", "Unable to fetch students");

			req.getRequestDispatcher("WEB-INF/views/viewStudents.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
