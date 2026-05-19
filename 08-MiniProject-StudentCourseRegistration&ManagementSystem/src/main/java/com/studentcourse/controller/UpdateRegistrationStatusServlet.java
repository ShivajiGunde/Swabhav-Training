package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateRegistrationStatusServlet")
public class UpdateRegistrationStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int registrationId = Integer.parseInt(req.getParameter("registrationId"));
        String status = req.getParameter("status");

        RegistrationDAO dao = new RegistrationDAO();
        dao.updateStatus(registrationId, status);

        resp.sendRedirect("ViewRegistrationsServlet");
    }
}