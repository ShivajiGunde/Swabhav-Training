package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {

    CourseDAO courseDAO;

    @Override
    public void init() {
        courseDAO = new CourseDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");

        if (idStr == null || idStr.trim().isEmpty()) {

            request.setAttribute("errorMessage", "Invalid Course ID");
            request.getRequestDispatcher("WEB-INF/views/course-list.jsp")
                    .forward(request, response);
            return;
        }

        int courseId = Integer.parseInt(idStr);

        
        boolean deleted = courseDAO.deleteCourse(courseId);

        if (deleted) {

            response.sendRedirect("ViewCoursesServlet");

        } else {

            request.setAttribute("errorMessage", "Failed to delete course");
            request.getRequestDispatcher("WEB-INF/views/course-list.jsp")
                    .forward(request, response);
        }
    }
}