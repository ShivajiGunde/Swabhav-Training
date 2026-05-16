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
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException, ServletException {

        int studentId = Integer.parseInt(req.getParameter("studentId"));

        StudentDAO dao = new StudentDAO();

        Student student = dao.getStudentById(studentId);

        req.setAttribute("student", student);

        req.getRequestDispatcher("/WEB-INF/views/update-student.jsp")
           .forward(req, resp);
    }
}