package com.studentcourse.controller;
import java.io.IOException;

import com.studentcourse.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet{
	
	StudentDAO studentDAO = new StudentDAO();
	
	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String idStr = request.getParameter("studentId");

    if (idStr == null || idStr.trim().isEmpty()) {

        response.sendRedirect("ViewStudentsServlet");
        return;
    }

    int studentId;

    try {
        studentId = Integer.parseInt(idStr);
    } catch (Exception e) {
        response.sendRedirect("ViewStudentsServlet");
        return;
    }

    boolean isRegistered = studentDAO.isStudentRegistered(studentId);

    if (isRegistered) {

        request.setAttribute("errorMessage",
                "Cannot delete student. Student is registered in a course.");

        request.getRequestDispatcher("/WEB-INF/views/student-list.jsp")
               .forward(request, response);

    } else {

        studentDAO.deleteStudent(studentId);

        response.sendRedirect("ViewStudentsServlet");
    }
}

}