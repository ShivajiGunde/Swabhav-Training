package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditCourseServlet")
public class EditCourseServlet extends HttpServlet{
	
	 @Override
	    protected void doGet(HttpServletRequest req,
	                         HttpServletResponse resp)
	            throws IOException, ServletException {

	        int courseId = Integer.parseInt(req.getParameter("courseId"));

	        CourseDAO dao = new CourseDAO();

	        Course course = dao.getCourseById(courseId);

	        req.setAttribute("course", course);

	        req.getRequestDispatcher("/WEB-INF/views/course-edit.jsp")
	           .forward(req, resp);
	    }


}
