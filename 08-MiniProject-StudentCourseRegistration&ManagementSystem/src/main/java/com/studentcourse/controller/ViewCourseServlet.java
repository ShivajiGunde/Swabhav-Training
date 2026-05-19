package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewCoursesServlet")
public class ViewCourseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CourseDAO dao = new CourseDAO();

		try {
		List<Course> courseList = dao.getAllCourses();

		request.setAttribute("courseList", courseList);
		
		request.getRequestDispatcher("/WEB-INF/views/course-list.jsp").forward(request, response);
	}catch(Exception e) {
		e.printStackTrace();
		
		request.setAttribute("errorMessage", "Unable to fetch courses");

		request.getRequestDispatcher("/WEB-INF/views/course-list.jsp").forward(request, response);
	}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}