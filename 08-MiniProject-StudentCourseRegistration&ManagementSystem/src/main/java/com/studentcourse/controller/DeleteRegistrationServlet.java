package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteRegistrationServlet")
	public class DeleteRegistrationServlet extends HttpServlet {

	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        int id = Integer.parseInt(req.getParameter("id"));

	        RegistrationDAO dao = new RegistrationDAO();
	        dao.deleteRegistration(id);

	        resp.sendRedirect("ViewRegistrationsServlet");
	    }
	}


