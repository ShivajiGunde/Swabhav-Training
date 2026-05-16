package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewRegistrationsServlet")
	public class ViewRegistrationsServlet extends HttpServlet{

	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        RegistrationDAO dao = new RegistrationDAO();

	        req.setAttribute("list", dao.getAllRegistrations());

	        req.getRequestDispatcher("/WEB-INF/views/view-registrations.jsp")
	           .forward(req, resp);
	    }
	}

}
