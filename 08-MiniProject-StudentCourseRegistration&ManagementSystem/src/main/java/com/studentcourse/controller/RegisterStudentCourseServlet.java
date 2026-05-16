package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.model.Registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterStudentCourseServlet")
	public class RegisterStudentCourseServlet extends HttpServlet {

	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        int studentId = Integer.parseInt(req.getParameter("studentId"));
	        int courseId = Integer.parseInt(req.getParameter("courseId"));

	        Registration r = new Registration();
	        r.setStudentId(studentId);
	        r.setCourseId(courseId);
	        r.setRegistrationDate(new java.sql.Date(System.currentTimeMillis()));
	        r.setStatus("ACTIVE");

	        RegistrationDAO dao = new RegistrationDAO();
	        dao.registerStudentCourse(r);

	        resp.sendRedirect("ViewRegistrationsServlet");
	    }
	}


