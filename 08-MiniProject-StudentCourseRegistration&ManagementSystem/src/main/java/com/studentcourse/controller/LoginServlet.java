package com.studentcourse.controller;

import java.io.IOException;

import com.mysql.cj.Session;
import com.studentcourse.dao.AdminDAO;
import com.studentcourse.model.Admin;
import com.studentcourse.util.DBConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServletAdmin")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
	        throws ServletException, IOException {

	    request.getRequestDispatcher("/WEB-INF/views/login.jsp")
	           .forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		String username = req.getParameter("username");

		String password = req.getParameter("password");

		String remember = req.getParameter("remember");

		AdminDAO dao = new AdminDAO();

		if (dao.isValid(username, password)) {

			HttpSession session = req.getSession();

			session.setAttribute("username", username);

			if (remember != null && remember.equals("yes")) {

				Cookie cookie = new Cookie("username", username);
				cookie.setMaxAge(5 * 60);
				resp.addCookie(cookie);

			}
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
			rd.forward(req, resp);

		} else {

			req.setAttribute("error", "Invalid Username or Password");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(req, resp);

			// resp.sendRedirect("login.jsp");

		}
	}
}
